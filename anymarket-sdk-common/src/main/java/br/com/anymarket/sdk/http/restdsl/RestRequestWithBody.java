package br.com.anymarket.sdk.http.restdsl;

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
        if(statusCode >= 500){
            throw new HttpServerException(response.getBody());
        }
        else if(statusCode == 401){
            throw new UnauthorizedException(response.getBody());
        }
        else if(statusCode >= 400 && statusCode != 404){
            throw new HttpClientException(response.getBody());
        }

    }
}
