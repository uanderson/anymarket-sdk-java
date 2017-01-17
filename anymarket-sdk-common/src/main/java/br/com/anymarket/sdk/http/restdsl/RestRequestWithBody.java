package br.com.anymarket.sdk.http.restdsl;

import br.com.anymarket.sdk.dto.ErrorDTO;
import br.com.anymarket.sdk.exception.HttpClientException;
import br.com.anymarket.sdk.exception.HttpServerException;
import br.com.anymarket.sdk.exception.UnauthorizedException;
import br.com.anymarket.sdk.http.Mapper;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;

import java.io.IOException;

public class RestRequestWithBody {
    private HttpRequestWithBody request;
    private Object body;


    public RestRequestWithBody(HttpRequestWithBody request) {
        this.request = request;
    }

    public RestRequestWithBody queryString(String key, String value) {
        request.queryString(key, value);
        return this;
    }

    public RestRequestWithBody headers(IntegrationHeader[] headers) {
        for (IntegrationHeader header : headers) {
            request.header(header.getKey(), header.getValue());
        }
        return this;
    }

    public RestRequestWithBody routeParam(String key, String value) {
        request.routeParam(key, value);
        return this;
    }

    public RestRequestWithBody body(Object body) {
        this.body = body;
        return this;
    }

    public Response getResponse() {
        try {
            String bodyAsString = Mapper.get().writeValueAsString(body);
            HttpResponse<String> response = request.body(bodyAsString).asString();
            checkGenericErrorToThrowGenericException(response);
            return new Response(response.getStatus(), response.getBody());
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkGenericErrorToThrowGenericException(HttpResponse<String> response) {
        int statusCode = response.getStatus();
        String message = response.getBody();
        String details = null;
        try {
            ErrorDTO errorDTO = Mapper.get().readValue(response.getBody(), ErrorDTO.class);
            message = errorDTO.getMessage();
            details = errorDTO.getDetails();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (statusCode >= 500) {
            throw new HttpServerException(message, details);
        } else if (statusCode == 401) {
            throw new UnauthorizedException(message);
        } else if (statusCode >= 400 && statusCode != 404) {
            throw new HttpClientException(message, details);
        }

    }
}
