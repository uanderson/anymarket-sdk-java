package br.com.anymarket.sdk.order.filters;

public class OrderPaymentMethodFilter extends OrderFilter {

    public OrderPaymentMethodFilter(String value) {
        super(value);
    }

    @Override
    public String getKey() {
        return "paymentMethod";
    }
}
