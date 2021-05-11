package br.com.anymarket.sdk.order.filters;

public class OrderNumberInMarketPlaceFilter extends OrderFilter {

    public OrderNumberInMarketPlaceFilter(String value) {
        super(value);
    }

    @Override
    public String getKey() {
        return "orderNumberInMarketPlace";
    }
}
