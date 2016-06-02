package br.com.anymarket.sdk.product.dto;

import br.com.anymarket.sdk.MarketPlace;
import br.com.anymarket.sdk.product.dto.deserializer.VariationDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SkuMarketPlace {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("idInMarketplace")
    private String idInMarketplace;

    @JsonProperty("marketPlace")
    private MarketPlace marketPlace;

    @JsonProperty("index")
    private Long index;

    @JsonProperty("publicationStatus")
    private String publicationStatus;

    @JsonProperty("marketplaceStatus")
    private String marketplaceStatus;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("discountPrice")
    private BigDecimal discountPrice;

    @JsonProperty(value = "fields")
    @JsonDeserialize(using = VariationDeserializer.class)
    private Map<String, String> fields = new HashMap<String, String>();

    private SkuMarketPlace(Builder builder) {
        setIdInMarketplace(builder.idInMarketplace);
        setMarketPlace(builder.marketPlace);
        setIndex(builder.index);
        setPublicationStatus(builder.publicationStatus);
        setMarketplaceStatus(builder.marketplaceStatus);
        setPrice(builder.price);
        setDiscountPrice(builder.discountPrice);
        setFields(builder.fields);
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdInMarketplace() {
        return idInMarketplace;
    }

    public void setIdInMarketplace(String idInMarketplace) {
        this.idInMarketplace = idInMarketplace;
    }

    public MarketPlace getMarketPlace() {
        return marketPlace;
    }

    public void setMarketPlace(MarketPlace marketPlace) {
        this.marketPlace = marketPlace;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public String getPublicationStatus() {
        return publicationStatus;
    }

    public void setPublicationStatus(String publicationStatus) {
        this.publicationStatus = publicationStatus;
    }

    public String getMarketplaceStatus() {
        return marketplaceStatus;
    }

    public void setMarketplaceStatus(String marketplaceStatus) {
        this.marketplaceStatus = marketplaceStatus;
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

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "SkuMarketPlace{" +
            "id=" + id +
            ", idInMarketplace='" + idInMarketplace + '\'' +
            ", marketPlace=" + marketPlace +
            ", index=" + index +
            ", publicationStatus='" + publicationStatus + '\'' +
            ", marketplaceStatus='" + marketplaceStatus + '\'' +
            ", price=" + price +
            ", discountPrice=" + discountPrice +
            ", fields=" + fields +
            '}';
    }

    public static final class Builder {
        private String idInMarketplace;
        private MarketPlace marketPlace;
        private Long index;
        private String publicationStatus;
        private String marketplaceStatus;
        private BigDecimal price;
        private BigDecimal discountPrice;
        private Map<String, String> fields;

        private Builder() {
        }

        public Builder withIdInMarketplace(String val) {
            idInMarketplace = val;
            return this;
        }

        public Builder withMarketPlace(MarketPlace val) {
            marketPlace = val;
            return this;
        }

        public Builder withIndex(Long val) {
            index = val;
            return this;
        }

        public Builder withPublicationStatus(String val) {
            publicationStatus = val;
            return this;
        }

        public Builder withMarketplaceStatus(String val) {
            marketplaceStatus = val;
            return this;
        }

        public Builder withPrice(BigDecimal val) {
            price = val;
            return this;
        }

        public Builder withDiscountPrice(BigDecimal val) {
            discountPrice = val;
            return this;
        }

        public Builder withFields(Map<String, String> val) {
            fields = val;
            return this;
        }

        public SkuMarketPlace build() {
            return new SkuMarketPlace(this);
        }
    }
}
