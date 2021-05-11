package br.com.anymarket.sdk.order.filters;

public class OrderMarketplaceIdFilter extends OrderFilter {

    public OrderMarketplaceIdFilter(String value) {
        super(value);
    }

    @Override
    public String getKey() {
        return "marketplaceId";
    }
}
