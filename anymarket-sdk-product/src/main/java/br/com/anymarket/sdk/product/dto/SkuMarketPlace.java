package br.com.anymarket.sdk.product.dto;

import br.com.anymarket.sdk.MarketPlace;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SkuMarketPlace implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("idInMarketplace")
    private String idInMarketplace;

    @JsonProperty("marketPlace")
    private MarketPlace marketPlace;

    @JsonProperty("index")
    private Integer index;

    @JsonProperty("publicationStatus")
    private String publicationStatus;

    @JsonProperty("marketplaceStatus")
    private String marketplaceStatus;

    @JsonProperty(value = "transmissionStatus")
    private String transmissionStatus;

    @JsonProperty(value = "errorMsg")
    private String errorMsg;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("priceFactor")
    private BigDecimal priceFactor;

    @JsonProperty("discountPrice")
    private BigDecimal discountPrice;

    @JsonProperty(value = "skuInMarketplace")
    private String skuInMarketplace;

    @JsonProperty(value = "fields")
    private Map<String, String> fields = new HashMap<String, String>();

    protected SkuMarketPlace() {
        //to serialize
    }

    private SkuMarketPlace(Builder builder) {
        setIdInMarketplace(builder.idInMarketplace);
        setMarketPlace(builder.marketPlace);
        setIndex(builder.index);
        setPublicationStatus(builder.publicationStatus);
        setTransmissionStatus(builder.transmissionStatus);
        setErrorMsg(builder.errorMsg);
        setMarketplaceStatus(builder.marketplaceStatus);
        setPrice(builder.price);
        setPriceFactor(builder.priceFactor);
        setDiscountPrice(builder.discountPrice);
        setSkuInMarketplace(builder.skuInMarketplace);
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

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getPublicationStatus() {
        return publicationStatus;
    }

    public void setPublicationStatus(String publicationStatus) {
        this.publicationStatus = publicationStatus;
    }

    public String getTransmissionStatus() {
        return transmissionStatus;
    }

    public void setTransmissionStatus(String transmissionStatus) {
        this.transmissionStatus = transmissionStatus;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
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

    public BigDecimal getPriceFactor() {
        return priceFactor;
    }

    public void setPriceFactor(BigDecimal priceFactor) {
        this.priceFactor = priceFactor;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getSkuInMarketplace() {
        return skuInMarketplace;
    }

    public void setSkuInMarketplace(String skuInMarketplace) {
        this.skuInMarketplace = skuInMarketplace;
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
        private Integer index;
        private String publicationStatus;
        private String transmissionStatus;
        private String errorMsg;
        private String marketplaceStatus;
        private BigDecimal price;
        private BigDecimal priceFactor;
        private BigDecimal discountPrice;
        private String skuInMarketplace;
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

        public Builder withIndex(Integer val) {
            index = val;
            return this;
        }

        public Builder withPublicationStatus(String val) {
            publicationStatus = val;
            return this;
        }

        public Builder withTransmissionStatus(String val) {
            transmissionStatus = val;
            return this;
        }

        public Builder withErrorMsg(String val) {
            errorMsg = val;
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

        public Builder withPriceFactor(BigDecimal val) {
            priceFactor = val;
            return this;
        }

        public Builder withDiscountPrice(BigDecimal val) {
            discountPrice = val;
            return this;
        }

        public Builder withSkuInMarketplace(String val) {
            skuInMarketplace = val;
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
