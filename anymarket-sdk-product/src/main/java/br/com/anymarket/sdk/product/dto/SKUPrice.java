package br.com.anymarket.sdk.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;
import static java.math.BigDecimal.ZERO;
import static java.util.Objects.isNull;

/**
 * Valores de preço do SKU
 */
public class SKUPrice {

    @JsonProperty("price")
    private BigDecimal price;
    @JsonProperty("discountPrice")
    private BigDecimal discountPrice;

    public SKUPrice(BigDecimal price) {
        this(price, price);
    }

    public SKUPrice(BigDecimal price, BigDecimal discountPrice) {
        checkArgument(!isNull(price) && price.compareTo(ZERO) > 0, "Preço de venda precisa ser informado");
        checkArgument(!isNull(discountPrice) && discountPrice.compareTo(ZERO) > 0, "Preço com desconto precisa ser informado. Informe um desconto válido.");
        checkArgument(price.compareTo(discountPrice) >= 0, "Preço com desconto não pode ser maior que o preço de venda. Informe um desconto válido.");

        this.price = price;
        this.discountPrice = discountPrice;
    }

    public SKUPrice() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SKUPrice skuPrice = (SKUPrice) o;
        return price.compareTo(skuPrice.price) == 0 &&
                discountPrice.compareTo(skuPrice.discountPrice) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(price, discountPrice);
    }
}