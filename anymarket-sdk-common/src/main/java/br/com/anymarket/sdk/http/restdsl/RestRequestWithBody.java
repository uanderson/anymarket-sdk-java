package br.com.anymarket.sdk.http.restdsl;

import br.com.anymarket.sdk.dto.ErrorDTO;
import br.com.anymarket.sdk.exception.HttpClientException;
import br.com.anymarket.sdk.exception.HttpServerException;
import br.com.anymarket.sdk.exception.UnauthorizedException;
import br.com.anymarket.sdk.http.Mapper;
import br.com.anymarket.sdk.http.Response;
import br.com.anymarket.sdk.http.headers.IntegrationHeader;
import br.com.anymarket.sdk.http.headers.NewOrderTotalsPatternHeader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
        NewOrderTotalsPatternHeader newOrderPattern = new NewOrderTotalsPatternHeader();
        request.header(newOrderPattern.getKey(), newOrderPattern.getValue());
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

    public Response getResponseXML() {
        try {
            HttpResponse<String> response = request.body(body.toString()).asString();
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

    public InputStream getResponseByte() {
        try {
            String bodyAsString = Mapper.get().writeValueAsString(body);
            HttpResponse<InputStream> response = request.body(bodyAsString).asBinary();
            checkGenericErrorToThrowGenericExceptionToInputStream(response);
            return response.getBody();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkGenericErrorToThrowGenericExceptionToInputStream(HttpResponse<InputStream> response) {
        int statusCode = response.getStatus();
        if (statusCode >= 400 && statusCode != 404) {
            String message = null;
            String details = null;
            try {
                    message = CharStreams.toString(new InputStreamReader( response.getBody(), Charsets.UTF_8));
                    ErrorDTO errorDTO = Mapper.get().readValue(CharStreams.toString(new InputStreamReader( response.getBody(), Charsets.UTF_8)), ErrorDTO.class);
                    message = errorDTO.getMessage();
                    details = errorDTO.getDetails();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
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
