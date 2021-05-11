package br.com.anymarket.sdk.http;

import br.com.anymarket.sdk.exception.NotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.http.HttpStatus;

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
            checkNotFound(typeReference.getClass());
            return Mapper.get().readValue(message, typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T to(Class<T> clazz) {
        try {
            checkNotFound(clazz);
            return Mapper.get().readValue(message, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> void checkNotFound(Class<T> clazz) {
        if (status == HttpStatus.SC_NOT_FOUND) {
            throw new NotFoundException(message);
        }
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
