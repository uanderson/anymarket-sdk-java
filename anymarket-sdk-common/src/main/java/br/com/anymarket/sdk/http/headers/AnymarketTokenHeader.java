package br.com.anymarket.sdk.http.headers;

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
}
