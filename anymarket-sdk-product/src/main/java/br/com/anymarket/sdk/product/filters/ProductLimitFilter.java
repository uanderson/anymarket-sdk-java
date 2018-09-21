package br.com.anymarket.sdk.product.filters;

public class ProductLimitFilter extends ProductFilter {

    public ProductLimitFilter(Long limit) {
        super(limit.toString());
    }

    @Override
    public String getKey() {
        return "limit";
    }
}
