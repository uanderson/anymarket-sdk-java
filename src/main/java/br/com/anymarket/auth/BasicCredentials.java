package br.com.anymarket.auth;

import static com.google.common.base.Preconditions.checkNotNull;

public class BasicCredentials implements Credentials {

    private String token;

    public BasicCredentials(String token) {
        checkNotNull(token, "Token must not be null");
        this.token = token;
    }

    @Override
    public String getToken() {
        return token;
    }
}
