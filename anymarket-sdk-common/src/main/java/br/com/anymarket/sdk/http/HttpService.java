package br.com.anymarket.sdk.http;

import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.http.restdsl.RestResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.BaseRequest;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;

import java.io.IOException;

public class HttpService {

    protected HttpRequestWithBody put(String url, IntegrationHeader... headers) {
        HttpRequestWithBody put = Unirest.put(url);
        addHeaders(put, headers);
        return put;
    }

    protected GetRequest get(String url, IntegrationHeader... headers) {
        GetRequest unirest = Unirest.get(url);
        addHeaders(unirest, headers);

        return unirest;
    }

    protected HttpRequestWithBody post(String url, Object body, IntegrationHeader... headers) {
        HttpRequestWithBody post = Unirest.post(url);
        addHeaders(post, headers);

        return post;
    }

    protected RestResponse execute(BaseRequest request) {
        try {
            HttpResponse<String> response = request.asString();
            return new RestResponse(response.getStatus(), response.getBody());
        } catch (UnirestException e) {
            return null;
        }
    }

    protected RestResponse executeWithBody(Object body, HttpRequestWithBody request) {
        try {
            HttpResponse<String> response = request.body(writeValue(body)).asString();
            return new RestResponse(response.getStatus(), response.getBody());
        } catch (UnirestException e) {
            return null;
        }
    }

    public <T> T readValue(String value, TypeReference<T> valueType) {
        try {
            return Mapper.get().readValue(value, valueType);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public String writeValue(Object value) {
        try {
            return Mapper.get().writeValueAsString(value);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void addHeaders(HttpRequest request, IntegrationHeader... headers) {
        for (IntegrationHeader header : headers) {
            request.header(header.getKey(), header.getValue());
        }
    }

}
