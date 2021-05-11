package br.com.anymarket.sdk.freight.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class FreightDimension {

    @JsonProperty("height")
    private BigDecimal height = BigDecimal.ZERO;

    @JsonProperty("width")
    private BigDecimal width = BigDecimal.ZERO;

    @JsonProperty("weight")
    private BigDecimal weight = BigDecimal.ZERO;

    @JsonProperty("length")
    private BigDecimal length = BigDecimal.ZERO;

    public FreightDimension() {

    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }
}
