package br.com.anymarket.sdk.http.headers;

/**
 * Created by marcio.scharam on 18/02/2016.
 */
public class AnymarketTokenHeader implements IntegrationHeader {

    private static final String key = "gumgaToken";
    private String token;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AnymarketTokenHeader that = (AnymarketTokenHeader) o;

        return token.equals(that.token);

    }

    @Override
    public int hashCode() {
        return token.hashCode();
    }

    @Override
    public String toString() {
        return "AnymarketTokenHeader{" +
            "token='" + token + '\'' +
            '}';
    }
}
