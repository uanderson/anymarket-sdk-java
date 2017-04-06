package br.com.anymarket.sdk.categories.dto.marketplace;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class MarketplaceCategory {

    public MarketplaceCategory() {
    }

    public MarketplaceCategory(String codeInMarketplace) {
        this.codeInMarketplace = codeInMarketplace;
    }

    @JsonProperty("codeInMarketplace")
    private String codeInMarketplace;

    @JsonProperty("name")
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MarketplaceCategory category = (MarketplaceCategory) o;
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
