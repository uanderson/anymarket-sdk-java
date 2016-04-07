package br.com.anymarket.sdk.http.headers;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * Created by marcio.scharam on 18/02/2016.
 */
public class AnymarketTokenHeader implements IntegrationHeader {

    private static final String KEY = "gumgaToken";
    private String token;

    public AnymarketTokenHeader() {
    }

    public AnymarketTokenHeader(String token) {
        checkArgument(!isNullOrEmpty(token), "Passed token can't be null or empty");
        this.token = token;
    }

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public String getValue() {
        return token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AnymarketTokenHeader that = (AnymarketTokenHeader) o;
        return Objects.equals(KEY, that.getKey()) && Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(KEY, token);
    }
}
