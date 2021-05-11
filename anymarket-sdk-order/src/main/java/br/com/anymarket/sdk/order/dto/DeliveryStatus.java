package br.com.anymarket.sdk.order.dto;

/**
 * Created by gyowannyqueiroz on 5/16/16.
 */
public enum DeliveryStatus {
    UNKNOWN("Desconhecido"),
    IN_TRANSIT("Em trânsito"),
    DELIVERED("Entregue"),
    HOLD_FOR_PICKUP("Aguardando retirada"),
    DELAYED("Atrasado"),
    DELIVERED_LATE("Entregue atrasado");

    private final String description;

    private DeliveryStatus(String desc) {
        description = desc;
    }

    public String getDescription() {
        return description;
    }
}
