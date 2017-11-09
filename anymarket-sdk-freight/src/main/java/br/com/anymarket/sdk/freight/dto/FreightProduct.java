package br.com.anymarket.sdk.freight.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class FreightProduct {

    @JsonProperty("skuId")
    private String skuId;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("dimensions")
    private FreightDimension dimensions;

    @JsonProperty("stockAmount")
    private BigDecimal stockAmount;

    @JsonProperty("additionalDeliveryTime")
    private Integer additionalDeliveryTime;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("discountPrice")
    private BigDecimal discountPrice;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public FreightDimension getDimensions() {
        return dimensions;
    }

    public void setDimensions(FreightDimension dimensions) {
        this.dimensions = dimensions;
    }

    public BigDecimal getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(BigDecimal stockAmount) {
        this.stockAmount = stockAmount;
    }

    public Integer getAdditionalDeliveryTime() {
        return additionalDeliveryTime;
    }

    public void setAdditionalDeliveryTime(Integer additionalDeliveryTime) {
        this.additionalDeliveryTime = additionalDeliveryTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

}