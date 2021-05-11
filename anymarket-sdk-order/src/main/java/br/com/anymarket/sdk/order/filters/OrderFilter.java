package br.com.anymarket.sdk.order.filters;

import br.com.anymarket.sdk.http.filters.ApiFilter;
import com.google.common.base.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

/**
 *
 */
public abstract class OrderFilter implements ApiFilter {

    private String value;

    public OrderFilter(String value) {
        checkArgument(!isNullOrEmpty(value), "Passed filter can't be null or empty");
        this.value = value;
    }

    @Override
    public abstract String getKey();

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderFilter that = (OrderFilter) o;
        return Objects.equal(getKey(), that.getKey());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getKey());
    }
}
