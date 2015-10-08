package br.com.anymarket.http;

import br.com.anymarket.auth.Credentials;
import br.com.anymarket.auth.CredentialsProvider;
import br.com.anymarket.auth.DefaultCredentialsProviderChain;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.BaseRequest;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.mashape.unirest.request.body.RequestBodyEntity;

import java.io.IOException;

import static com.google.common.base.Preconditions.checkNotNull;

public class HttpService {

    private CredentialsProvider credentialsProvider;

    public HttpService() {
        this(new DefaultCredentialsProviderChain());
    }

    public HttpService(CredentialsProvider credentialsProvider) {
        checkNotNull(credentialsProvider, "Credentials provider must not be null");
        this.credentialsProvider = credentialsProvider;
    }

    protected RequestBodyEntity put(String path, Object body) {
        HttpRequestWithBody put = Unirest.put("http://sandbox-api.anymarket.com.br/v2" + path);
        addDefaultHeaders(put);

        return put.body(writeValue(body));
    }

    protected Response execute(BaseRequest request) {
        try {
            HttpResponse<String> response = request.asString();
            return new Response(response.getStatus(), response.getBody());
        } catch (UnirestException e) {
            return null;
        }
    }


    protected GetRequest get(String path) {
        GetRequest unirest = Unirest.get("http://sandbox-api.anymarket.com.br/v2" + path);
        addDefaultHeaders(unirest);

        return unirest;
    }

    private void addDefaultHeaders(HttpRequest request) {
        Credentials credentials = credentialsProvider.getCredentials();
        request.header("gumgaToken", credentials.getToken());
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

}
