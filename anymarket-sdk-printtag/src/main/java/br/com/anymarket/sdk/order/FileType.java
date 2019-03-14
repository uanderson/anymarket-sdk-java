package br.com.anymarket.sdk.order;

public enum FileType {
    TXT("txt"),
    PLP("plp");

    private final String name;

    FileType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
