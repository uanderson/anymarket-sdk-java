package br.com.anymarket.sdk.order.dto;

public enum OrderCancellationCode {

    WITHOUT_STOCK("Sem estoque"),
    SHIPPING_ADDRESS("Endereço de envio indisponível para entrega"),
    CUSTOMER_EXCHANGE("Troca de produto"),
    GENERAL_ADJUSTMENT("Ajuste geral"),
    CUSTOMER_RETURN("Erro de preço"),
    BUYER_CANCELED("Cancelado pelo cliente"),
    OTHER("Outro");

    private String description;

    OrderCancellationCode(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
