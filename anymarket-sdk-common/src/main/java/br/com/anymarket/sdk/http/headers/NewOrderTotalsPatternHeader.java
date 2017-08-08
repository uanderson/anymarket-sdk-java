package br.com.anymarket.sdk.http.headers;

/**
 * Created by marcio.scharam on 02/08/2017.
 */
public class NewOrderTotalsPatternHeader implements IntegrationHeader {
    @Override
    public String getKey() {
        return "orderNewPattern";
    }

    @Override
    public String getValue() {
        return "true";
    }
}
