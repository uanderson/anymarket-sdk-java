package br.com.anymarket.sdk.marketplaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MarketPlacesDTO {

    @JsonProperty("marketplaces")
    private List<MarketPlaceDTO> marketplaces;

    public List<MarketPlaceDTO> getMarketplaces() {
        return marketplaces;
    }

    public void setMarketplaces(List<MarketPlaceDTO> marketplaces) {
        this.marketplaces = marketplaces;
    }
}
