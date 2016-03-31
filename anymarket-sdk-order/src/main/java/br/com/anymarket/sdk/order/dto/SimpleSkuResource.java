package br.com.anymarket.sdk.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SimpleSkuResource {

    @JsonProperty("partnerId")
    private String partnerId;

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }
}