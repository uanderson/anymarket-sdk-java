package br.com.anymarket.sdk.freight;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FreightType {

    NORMAL ("normal"),
    EXPRESS ("express");

    private final String name;

    FreightType(String name) {
        this.name = name;
    }

    @JsonCreator
    public static FreightType fromString(String key) {
        return key == null
            ? null
            : FreightType.valueOf(key.toUpperCase());
    }

    @JsonValue
    public String getName() {
        return name;
    }


}
