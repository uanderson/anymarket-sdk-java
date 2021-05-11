package br.com.anymarket.sdk.dto;

import com.google.common.base.Objects;

public class MarketPlaceAccount {

    private Long id;
    private String name;

    protected MarketPlaceAccount(){}

    public MarketPlaceAccount(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MarketPlaceAccount that = (MarketPlaceAccount) o;
        return Objects.equal(id, that.id) &&
            Objects.equal(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name);
    }

    @Override
    public String toString() {
        return "MarketPlaceAccount{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
