package br.com.anymarket.sdk.http.headers;

import br.com.anymarket.sdk.SDKConstants;

public class ModuleOriginHeader implements IntegrationHeader {

    private String value;

    public ModuleOriginHeader(String value) {
        this.value = value;
    }

    @Override
    public String getKey() {
        return SDKConstants.ANYMARKET_MODULE_ORIGIN_HEADER;
    }

    @Override
    public String getValue() {
        return value;
    }
}
