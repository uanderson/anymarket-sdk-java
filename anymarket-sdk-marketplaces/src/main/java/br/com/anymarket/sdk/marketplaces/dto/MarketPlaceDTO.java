package br.com.anymarket.sdk.marketplaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketPlaceDTO {

    @JsonProperty("code")
    private String code;

    @JsonProperty("name")
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
