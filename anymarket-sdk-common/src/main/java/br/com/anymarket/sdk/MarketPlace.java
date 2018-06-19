package br.com.anymarket.sdk;

public enum MarketPlace {
    CNOVA("Via Varejo"),
    MAGENTO("Magento"),
    MERCADO_LIVRE("Mercado Livre"),
    B2W("B2W"),
    ECOMMERCE("E-Commerce"),
    WALMART("Walmart"),
    VTEX("VTEX"),
    GFG("GFG - Dafiti"),
    NETSHOES("Netshoes"),
    MAGAZINE_LUIZA("Magazine Luiza"),
    CARREFOUR("Carrefour"),
    AMAZON("Amazon"),
    BUSCAPE("Buscapé"),
    ORACLECOMMERCE("Oracle Commerce Cloud"),
    MADEIRA_MADEIRA("Madeira Madeira"),
    CISSA_MAGAZINE("Cissa Magazine"),
    B2W_NEW_API("B2W Nova API"),
    RICARDO_ELETRO("Ricardo Eletro");

    private String name;

    private MarketPlace(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.name;
    }
}
