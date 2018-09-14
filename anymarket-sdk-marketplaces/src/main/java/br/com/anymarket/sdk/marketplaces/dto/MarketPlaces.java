package br.com.anymarket.sdk.marketplaces.dto;

import br.com.anymarket.sdk.MarketPlace;
import com.fasterxml.jackson.annotation.JsonProperty;

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
