package br.com.anymarket.sdk.order.dto;

public enum MarketPlace {
    CNOVA("Cnova"),
    MAGENTO("Magento"),
    MERCADO_LIVRE("Mercado Livre"),
    B2W("B2W"),
    ECOMMERCE("E-Commerce"),
    WALMART("Walmart");

    private String name;

    private MarketPlace(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.name;
    }
}