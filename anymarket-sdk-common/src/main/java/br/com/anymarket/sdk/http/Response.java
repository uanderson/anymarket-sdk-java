package br.com.anymarket.sdk.http;

import br.com.anymarket.sdk.paging.Page;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;

import java.io.IOException;

public class Response {

    private int status;
    private String message;

    public Response(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public <T> T to(TypeReference<T> typeReference) {
        try {
            return Mapper.get().readValue(message, typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T to(Class<T> clazz) {
        try {
            return Mapper.get().readValue(message, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> Page<T> toPage(Class<T> clazz) {
        JavaType pageType = Mapper
                .get()
                .getTypeFactory()
                .constructParametrizedType(Page.class, Page.class, clazz);
        try {
            return Mapper.get().readValue(message, pageType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
