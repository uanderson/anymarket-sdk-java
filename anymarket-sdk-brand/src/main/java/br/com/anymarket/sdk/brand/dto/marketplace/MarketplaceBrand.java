package br.com.anymarket.sdk.brand.dto.marketplace;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class MarketplaceBrand {

    @JsonProperty("codeInMarketplace")
    private String codeInMarketplace;

    @JsonProperty("name")
    private String name;

    public MarketplaceBrand() {
    }

    public MarketplaceBrand(String codeInMarketplace) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MarketplaceBrand brand = (MarketplaceBrand) o;
        return Objects.equal(codeInMarketplace, brand.codeInMarketplace) &&
                Objects.equal(name, brand.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codeInMarketplace, name);
    }

    @Override
    public String toString() {
        final StringBuilder brand = new StringBuilder("MarketplaceBrand{");
        brand.append("codeInMarketplace='").append(this.codeInMarketplace).append("\',");
        brand.append("name='").append(this.name).append("\'").append("}");
        return brand.toString();
   }
}
