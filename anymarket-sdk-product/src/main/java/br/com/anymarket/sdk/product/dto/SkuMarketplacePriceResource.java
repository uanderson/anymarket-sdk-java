package br.com.anymarket.sdk.product.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SkuMarketplacePriceResource {

    @JsonProperty(value = "price")
    private BigDecimal price;

    @JsonProperty(value = "discountPrice")
    private BigDecimal discountPrice;

    @JsonProperty(value = "fields")
    private List<SkuMarketplaceFieldsResource> fields;

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

    public List<SkuMarketplaceFieldsResource> getFields() {
        return fields;
    }

    public void setFields(List<SkuMarketplaceFieldsResource> fields) {
        this.fields = fields;
    }
}
