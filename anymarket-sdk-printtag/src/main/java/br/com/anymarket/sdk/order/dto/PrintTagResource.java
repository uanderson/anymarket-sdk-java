package br.com.anymarket.sdk.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PrintTagResource {

    @JsonProperty("orders")
    private List<Long> orders;

    public List<Long> getOrders() {
        return orders;
    }

    public void setOrders(List<Long> orders) {
        this.orders = orders;
    }
}
