package br.com.anymarket.sdk.order.filters;

import br.com.anymarket.sdk.order.dto.MarketPlace;

/**
 *
 */
public class OrderMarketplaceFilter extends OrderFilter {

    public OrderMarketplaceFilter(MarketPlace marketplace) {
        super(marketplace.toString());
    }

    @Override
    public String getKey() {
        return "marketplace";
    }


}
