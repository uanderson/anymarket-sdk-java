package br.com.anymarket.sdk.product.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransmissionDTO {

    @JsonProperty("publicationStatus")
    private String publicationStatus;
    @JsonProperty("marketplaceStatus")
    private String marketplaceStatus;
    @JsonProperty("permalink")
    private String permalink;
    @JsonProperty("marketPlaceCode")
    private String marketPlaceCode;


    private TransmissionDTO(Builder builder) {
        setPublicationStatus(builder.publicationStatus);
        setMarketplaceStatus(builder.marketplaceStatus);
        setMarketPlaceCode(builder.marketPlaceCode);
        setPermalink(builder.permalink);
    }

    public static Builder builder() {
        return new Builder();
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

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getMarketPlaceCode() {
        return marketPlaceCode;
    }

    public void setMarketPlaceCode(String marketPlaceCode) {
        this.marketPlaceCode = marketPlaceCode;
    }

    @Override
    public String toString() {
        return "SkuMarketPlace{" +
            ", publicationStatus='" + publicationStatus + '\'' +
            ", marketplaceStatus='" + marketplaceStatus + '\'' +
            '}';
    }

    public static final class Builder {
        private String publicationStatus;
        private String marketplaceStatus;
        private String marketPlaceCode;
        private String permalink;

        private Builder() {
        }

        public Builder withPublicationStatus(String val) {
            publicationStatus = val;
            return this;
        }

        public Builder withMarketplaceStatus(String val) {
            marketplaceStatus = val;
            return this;
        }

        public Builder withMarketPlaceCode(String val) {
            marketPlaceCode = val;
            return this;
        }

        public Builder withPermalink(String val) {
            permalink = val;
            return this;
        }

        public TransmissionDTO build() {
            return new TransmissionDTO(this);
        }
    }
}
