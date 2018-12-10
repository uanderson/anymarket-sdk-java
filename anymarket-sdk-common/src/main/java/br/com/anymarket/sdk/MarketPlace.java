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
    SARAIVA("Saraiva"),
    HUB_SALES("Hub Sales"),
    ZOOM("Zoom"),
    WEB_CONTINENTAL("Web Continental"),
    RICARDO_ELETRO("Ricardo Eletro"),
    PORTAL_DO_MEDICO("Portal do Médico"),
    TRAY("Tray"),
    CAMICADO("Camicado"),
    DIA_GROUP("Dia Group"),
    MIXTEL("Mixtel");

    private String name;

    private MarketPlace(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.name;
    }
}
