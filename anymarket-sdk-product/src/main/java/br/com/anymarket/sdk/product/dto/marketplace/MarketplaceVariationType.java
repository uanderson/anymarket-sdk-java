package br.com.anymarket.sdk.product.dto.marketplace;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.ArrayList;
import java.util.List;

public class MarketplaceVariationType {

    @JsonProperty("codeInMarketplace")
    private String codeInMarketplace;

    @JsonProperty("name")
    private String name;

    @JsonProperty("values")
    List<MarketplaceVariationValue> values = new ArrayList<MarketplaceVariationValue>();

    public MarketplaceVariationType() {
    }

    public MarketplaceVariationType(String codeInMarketplace) {
        this.codeInMarketplace = codeInMarketplace;
    }

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

    public List<MarketplaceVariationValue> getValues() {
        return values;
    }

    public void setValues(List<MarketplaceVariationValue> values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MarketplaceVariationType category = (MarketplaceVariationType) o;
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
            .add("values", values)
            .toString();
    }
}
