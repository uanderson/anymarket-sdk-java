package br.com.anymarket.sdk.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderItemShippingResource {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("shippingtype")
    private String shippingtype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShippingtype() {
        return shippingtype;
    }

    public void setShippingtype(String shippingtype) {
        this.shippingtype = shippingtype;
    }
}
