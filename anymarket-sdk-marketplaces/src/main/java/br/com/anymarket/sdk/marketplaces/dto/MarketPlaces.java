package br.com.anymarket.sdk.marketplaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MarketPlaces {

    @JsonProperty("marketplaces")
    private List<String> marketplaces;

    public List<String> getMarketplaces() {
        return marketplaces;
    }

    public void setMarketplaces(List<String> marketplaces) {
        this.marketplaces = marketplaces;
    }
}
