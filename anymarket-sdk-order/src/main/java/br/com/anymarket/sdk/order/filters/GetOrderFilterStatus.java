package br.com.anymarket.sdk.order.filters;

import br.com.anymarket.sdk.order.dto.OrderStatus;

/**
 * Created by marcos.trevisan on 31/03/2016.
 */
public class GetOrderFilterStatus implements IGetOrderFilter<OrderStatus> {
    private OrderStatus status;

    public GetOrderFilterStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String getKey() {
        return "status";
    }

    @Override
    public OrderStatus getValue() {
        return status;
    }
}
