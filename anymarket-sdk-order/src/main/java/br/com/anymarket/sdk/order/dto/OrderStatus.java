package br.com.anymarket.sdk.order.dto;

import java.util.Arrays;
import java.util.List;

public enum OrderStatus {

    PENDING("Pendente"),
    PAID_WAITING_SHIP("Pago", PENDING),
    INVOICED("Faturado", PENDING, PAID_WAITING_SHIP),
    PAID_WAITING_DELIVERY("Enviado", PENDING, PAID_WAITING_SHIP, INVOICED),
    CONCLUDED("Entregue", PENDING, PAID_WAITING_SHIP, INVOICED, PAID_WAITING_DELIVERY),
    CANCELED("Cancelado", PENDING, PAID_WAITING_SHIP, INVOICED, PAID_WAITING_DELIVERY, CONCLUDED);

    private final List<OrderStatus> incomes;
    private final String description;

    OrderStatus(String description, OrderStatus... incomes) {
        this.description = description;
        this.incomes = Arrays.asList(incomes);
    }

    public static OrderStatus fromString(String status) {
        try {
            return valueOf(status);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(status + " não é um status de pedido válido.", e);
        }
    }

    public Boolean acceptTransitionFrom(OrderStatus status) {
        return equals(status) || incomes.contains(status);
    }

    public Boolean isPendingOrPaid() {
        return this.equals(PENDING) || this.equals(PAID_WAITING_SHIP);
    }

    public Boolean isConfirmed() {
        return this.equals(INVOICED) || this.equals(PAID_WAITING_DELIVERY) || this.equals(CONCLUDED);
    }

    public String getDescription() {
        return description;
    }
}