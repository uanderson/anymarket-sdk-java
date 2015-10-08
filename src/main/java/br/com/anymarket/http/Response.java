package br.com.anymarket.http;

import br.com.anymarket.feed.MarkFeedAsReadRequest;
import br.com.anymarket.feed.MarkFeedAsReadResponse;
import com.fasterxml.jackson.core.type.TypeReference;

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
}
