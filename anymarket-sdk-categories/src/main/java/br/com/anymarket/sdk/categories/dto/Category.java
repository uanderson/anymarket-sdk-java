package br.com.anymarket.sdk.categories.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by marcio.scharam on 17/03/2016.
 */
public class Category {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("partnerId")
    private String partnerId;

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("priceFactor")
    private BigDecimal priceFactor;

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("calculatedPrice")
    private Boolean calculatedPrice;

    @JsonProperty("children")
    private List<Category> children = new ArrayList<Category>();

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("parent")
    private Category parent;

    @JsonProperty("path")
    private String path;

    @JsonProperty("definitionPriceScope")
    private DefinitionPriceScope definitionPriceScope;

    private Category() {}

    private Category(Builder builder) {
        if (builder.id == null && builder.partnerId == null) {
            throw new IllegalArgumentException(
                "It must be filled the id or partnerId");
        }
        checkNotNull(builder.name, "Name must be filled");

        this.id = builder.id;
        this.partnerId = builder.partnerId;
        this.name = builder.name;
        this.calculatedPrice = builder.calculatedPrice;
        this.priceFactor = builder.priceFactor;
        this.parent = builder.parent;
        this.children = builder.children;
        this.path = builder.path;
        this.definitionPriceScope = builder.definitionPriceScope;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public void setPriceFactor(BigDecimal priceFactor) {
        this.priceFactor = priceFactor;
    }

    public void setCalculatedPrice(Boolean calculatedPrice) {
        this.calculatedPrice = calculatedPrice;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setDefinitionPriceScope(DefinitionPriceScope definitionPriceScope) { this.definitionPriceScope = definitionPriceScope; };

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public BigDecimal getPriceFactor() {
        return priceFactor;
    }

    public Boolean getCalculatedPrice() {
        return calculatedPrice;
    }

    public List<Category> getChildren() {
        return children;
    }

    public Category getParent() {
        return parent;
    }

    public String getPath() {
        return path;
    }

    public DefinitionPriceScope getDefinitionPriceScope() {return definitionPriceScope; }

    public static Category.Builder builder() {
        return new Category.Builder();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("id", id)
            .add("name", name)
            .add("partnerId", partnerId)
            .add("priceFactor", priceFactor)
            .add("calculatedPrice", calculatedPrice)
            .add("children", children)
            .add("parent", parent)
            .add("path", path)
            .add("definitionPriceScope", definitionPriceScope)
            .toString();
    }

    public static class Builder {

        private Long id;
        private String name;
        private String partnerId;
        private BigDecimal priceFactor;
        private Boolean calculatedPrice;
        private List<Category> children = new ArrayList<Category>();
        private Category parent;
        private String path;
        private DefinitionPriceScope definitionPriceScope;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withPartnerId(String partnerId) {
            this.partnerId = partnerId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPriceFactor(BigDecimal priceFactor) {
            this.priceFactor = priceFactor;
            return this;
        }

        public Builder withCalculatedPrice(Boolean calculatedPrice) {
            this.calculatedPrice = calculatedPrice;
            return this;
        }

        public Builder withParent(Category parent) {
            this.parent = parent;
            return this;
        }

        public Builder withChildren(List<Category> children) {
            this.children = children;
            return this;
        }

        public Builder withPath(String path) {
            this.path = path;
            return this;
        }

        public Builder withDefinitionPriceScope(DefinitionPriceScope definitionPriceScope){
            this.definitionPriceScope = definitionPriceScope;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Category category = (Category) o;
        return Objects.equal(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
