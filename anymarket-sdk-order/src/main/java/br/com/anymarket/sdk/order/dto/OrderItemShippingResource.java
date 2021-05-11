package br.com.anymarket.sdk.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItemShippingResource {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("shippingtype")
    private String shippingtype;

    @JsonProperty("shippingCarrierNormalized")
    private String shippingCarrierNormalized;

    @JsonProperty("shippingCarrierTypeNormalized")
    private String shippingCarrierTypeNormalized;

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

    public String getShippingCarrierNormalized() {
        return shippingCarrierNormalized;
    }

    public void setShippingCarrierNormalized(String shippingCarrierNormalized) {
        this.shippingCarrierNormalized = shippingCarrierNormalized;
    }

    public String getShippingCarrierTypeNormalized() {
        return shippingCarrierTypeNormalized;
    }

    public void setShippingCarrierTypeNormalized(String shippingCarrierTypeNormalized) {
        this.shippingCarrierTypeNormalized = shippingCarrierTypeNormalized;
    }
}
