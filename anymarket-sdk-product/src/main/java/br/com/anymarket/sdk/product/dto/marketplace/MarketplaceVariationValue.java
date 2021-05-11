package br.com.anymarket.sdk.product.dto.marketplace;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class MarketplaceVariationValue {

    public MarketplaceVariationValue() {
    }

    public MarketplaceVariationValue(String codeInMarketplace) {
        this.codeInMarketplace = codeInMarketplace;
    }

    @JsonProperty("codeInMarketplace")
    private String codeInMarketplace;

    @JsonProperty("name")
    private String name;

    @JsonProperty("variationTypeCode")
    private String variationTypeCode;

    @JsonProperty("variationTypeName")
    private String variationTypeName;

    @JsonProperty("inputType")
    private String inputType;

    public String getCodeInMarketplace() {
        return codeInMarketplace;
    }

    public void setCodeInMarketplace(String codeInMarketplace) {
        this.codeInMarketplace = codeInMarketplace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariationTypeCode() {
        return variationTypeCode;
    }

    public void setVariationTypeCode(final String variationTypeCode) {
        this.variationTypeCode = variationTypeCode;
    }

    public String getVariationTypeName() {
        return variationTypeName;
    }

    public void setVariationTypeName(final String variationTypeName) {
        this.variationTypeName = variationTypeName;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(final String inputType) {
        this.inputType = inputType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MarketplaceVariationValue category = (MarketplaceVariationValue) o;
        return Objects.equal(codeInMarketplace, category.codeInMarketplace) &&
            Objects.equal(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codeInMarketplace, name);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("codeInMarketplace", codeInMarketplace)
            .add("name", name)
            .toString();
    }
}
