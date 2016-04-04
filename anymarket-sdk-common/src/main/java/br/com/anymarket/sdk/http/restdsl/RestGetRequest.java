package br.com.anymarket.sdk.http.restdsl;

import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;

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

    public RestGetRequest headers(IntegrationHeader[] headers) {
        for (IntegrationHeader header : headers) {
            request.header(header.getKey(), header.getValue());
        }
        return this;
    }

    public RestGetRequest routeParam(String key, String value) {
        request.routeParam(key, value);
        return this;
    }

    public RestResponse getResponse() {
        try {
            HttpResponse<String> response = request.asString();
            return new RestResponse(response.getStatus(), response.getBody());
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

}
