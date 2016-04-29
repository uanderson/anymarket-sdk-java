package br.com.anymarket.sdk.product.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Variation {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("description")
    private String value;

    @JsonProperty("type")
    private VariationType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public VariationType getType() {
        return type;
    }

    public void setType(VariationType type) {
        this.type = type;
    }
}
