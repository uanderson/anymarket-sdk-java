package br.com.anymarket.sdk.order.filters;

public class OrderPartnerIdFilter extends OrderFilter {

    public OrderPartnerIdFilter(String value) {
        super(value);
    }

    @Override
    public String getKey() {
        return "partnerId";
    }
}
