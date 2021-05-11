package br.com.anymarket.sdk.order;

public enum PrintType {
    PDF("pdf"),
    JSON("json"),
    ZPL2("zpl2");

    private final String name;

    PrintType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
