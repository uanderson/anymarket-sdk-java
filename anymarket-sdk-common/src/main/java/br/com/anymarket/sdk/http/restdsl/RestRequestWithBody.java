package br.com.anymarket.sdk.http.restdsl;

import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;

public class RestRequestWithBody {
    private HttpRequestWithBody request;
    private Object body;

    public RestRequestWithBody(HttpRequestWithBody request){
        this.request = request;
    }

    public RestRequestWithBody queryString(String key, String value){
        request.queryString(key, value);
        return this;
    }

    public RestRequestWithBody headers(IntegrationHeader[] headers){
        for(IntegrationHeader header: headers){
            request.header(header.getKey(), header.getValue());
        }
        return this;
    }

    public RestRequestWithBody routeParam(String key, String value){
        request.routeParam(key, value);
        return this;
    }

    public RestRequestWithBody body(Object body){
        this.body = body;
        return this;
    }

    public RestResponse getResponse(){
        try {
            HttpResponse<String> response = request.body(body).asString();
            return new RestResponse(response.getStatus(), response.getBody());
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
