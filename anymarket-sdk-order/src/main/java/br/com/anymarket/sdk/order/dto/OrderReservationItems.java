package br.com.anymarket.sdk.order.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderReservationItems {

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("sku")
    private SimpleSkuResource sku;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public SimpleSkuResource getSku() {
        return sku;
    }

    public void setSku(SimpleSkuResource sku) {
        this.sku = sku;
    }
}
