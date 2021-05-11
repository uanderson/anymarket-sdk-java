package br.com.anymarket.sdk.product.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Nbm {

    @JsonProperty("id")
    private String id;

    @JsonProperty("description")
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Nbm nbm = (Nbm) o;
        return Objects.equal(id, nbm.id) &&
            Objects.equal(description, nbm.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, description);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("id", id)
            .add("description", description)
            .toString();
    }
}
