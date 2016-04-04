package br.com.anymarket.sdk.http.headers;

/**
 * Created by marcio.scharam on 18/02/2016.
 */
public class AnymarketTokenHeader implements IntegrationHeader {

    private static final String key = "gumgaToken";
    private String token;

    public AnymarketTokenHeader() {
    }

    public AnymarketTokenHeader(String token) {
        this.token = token;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return token;
    }
}
