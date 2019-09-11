package br.com.anymarket.sdk.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.math.BigDecimal;

public class OrderItemStockResource {

    @JsonProperty("stockLocalId")
    private Long stockLocalId;

    @JsonProperty("amount")
    private BigDecimal amount;

    public Long getStockLocalId() {
        return stockLocalId;
    }

    public void setStockLocalId(Long stockLocalId) {
        this.stockLocalId = stockLocalId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("stockLocalId", stockLocalId)
                .add("amount", amount)
                .toString();
    }
}
