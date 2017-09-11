package br.com.anymarket.sdk.http.restdsl;

import br.com.anymarket.sdk.dto.ErrorDTO;
import br.com.anymarket.sdk.exception.HttpClientException;
import br.com.anymarket.sdk.exception.HttpServerException;
import br.com.anymarket.sdk.exception.UnauthorizedException;
import br.com.anymarket.sdk.http.Mapper;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.filters.ApiFilter;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.http.headers.NewOrderTotalsPatternHeader;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class RestGetRequest {

    private GetRequest request;

    public RestGetRequest(GetRequest request) {
        this.request = request;
    }

    public RestGetRequest queryString(String key, String value) {
        request.queryString(key, value);
        return this;
    }

    public RestGetRequest filters(List<? extends ApiFilter> filters) {
        if (filters != null) {
            for (ApiFilter filter : filters) {
                request.queryString(filter.getKey(), filter.getValue());
            }
        }
        return this;
    }

    public RestGetRequest filters(ApiFilter[] filters) {
        return filters(Arrays.asList(filters));
    }

    public RestGetRequest headers(IntegrationHeader[] headers) {
        for (IntegrationHeader header : headers) {
            request.header(header.getKey(), header.getValue());
        }
        NewOrderTotalsPatternHeader newOrderPattern = new NewOrderTotalsPatternHeader();
        request.header(newOrderPattern.getKey(), newOrderPattern.getValue());
        return this;
    }

    public RestGetRequest routeParam(String key, String value) {
        request.routeParam(key, value);
        return this;
    }

    public Response getResponse() {
        try {
            HttpResponse<String> response = request.asString();
            checkGenericErrorToThrowGenericException(response);
            return new Response(response.getStatus(), response.getBody());
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkGenericErrorToThrowGenericException(HttpResponse<String> response) {
        int statusCode = response.getStatus();
        if (statusCode >= 400 && statusCode != 404) {
            String message = response.getBody();
            String details = null;
            try {
                ErrorDTO errorDTO = Mapper.get().readValue(response.getBody(), ErrorDTO.class);
                message = errorDTO.getMessage();
                details = errorDTO.getDetails();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            if (statusCode >= 500) {
                throw new HttpServerException(statusCode, message, details);
            } else if (statusCode == 401) {
                throw new UnauthorizedException(message);
            }
            throw new HttpClientException(message, details);
        }
    }

}
