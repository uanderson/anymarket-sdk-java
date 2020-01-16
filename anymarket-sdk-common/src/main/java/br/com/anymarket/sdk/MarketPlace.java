package br.com.anymarket.sdk;

public enum MarketPlace {
    CNOVA("Via Varejo", "VRJ"),
    MAGENTO("Magento", "MGT"),
    MERCADO_LIVRE("Mercado Livre", "MLB"),
    B2W("B2W", "B2W"),
    ECOMMERCE("E-Commerce", "ECO"),
    WALMART("Walmart", "WAL"),
    VTEX("VTEX", "VTX"),
    GFG("GFG - Dafiti", "GFG"),
    NETSHOES("Netshoes", "NET"),
    MAGAZINE_LUIZA("Magazine Luiza", "MLU"),
    CARREFOUR("Carrefour", "CAR"),
    AMAZON("Amazon", "AMZ"),
    BUSCAPE("Buscapé", "BUS"),
    ORACLECOMMERCE("Oracle Commerce Cloud", "ORC"),
    MADEIRA_MADEIRA("Madeira Madeira", "MAD"),
    CISSA_MAGAZINE("Cissa Magazine", "CIS"),
    B2W_NEW_API("B2W Nova API", "B2W"),
    SARAIVA("Saraiva", "SRV"),
    HUB_SALES("Hub Sales", "HUB"),
    ZOOM("Zoom", "ZOM"),
    WEB_CONTINENTAL("Web Continental", "WEB"),
    RICARDO_ELETRO("Ricardo Eletro", "RIC"),
    CENTAURO("Centauro", "CEN"),
    PORTAL_DO_MEDICO("Portal do Médico", "MED"),
    TRAY("Tray", "TRA"),
    CAMICADO("Camicado", "CMC"),
    GALITHX("Go Core Marketplace (Galithx e Gorila Z)", "GLX"),
    COLOMBO("Lojas Colombo", "COL"),
    DIA_GROUP("Dia Group", "DIA"),
    ELETRUM("Eletrum", "ELT"),
    OPTEMAIS("Optemais", "OPT"),
    EFACIL("eFácil", "EFA"),
    LEROY_MERLIN("Leroy Merlin", "LRY"),
    COBASI("Cobasi", "COB"),
    CATWALK("Catwalk", "CAT"),
    WISH("Wish", "WSH"),
    HOME_TO_GO("Home To Go", "HTG"),
    CONNECT_PARTS("Connect Parts", "CNP"),
    GARBARINO("Garbarino", "GBN"),
    NOVOMUNDO("Novo Mundo", "NVM");

    private String name;
    private String abbreviation;

    private MarketPlace(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getDescription() {
        return this.name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
