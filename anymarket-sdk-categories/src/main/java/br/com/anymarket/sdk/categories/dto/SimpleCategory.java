package br.com.anymarket.sdk.categories.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class SimpleCategory {

    public SimpleCategory() {
    }

    public SimpleCategory(Long id) {
        this.id = id;
    }

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("path")
    private String path;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleCategory category = (SimpleCategory) o;
        return Objects.equal(id, category.id) &&
            Objects.equal(name, category.name) &&
            Objects.equal(path, category.path);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, path);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("id", id)
            .add("name", name)
            .add("path", path)
            .toString();
    }
}
