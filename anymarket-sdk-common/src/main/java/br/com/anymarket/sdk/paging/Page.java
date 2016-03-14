package br.com.anymarket.sdk.paging;

import br.com.anymarket.sdk.resource.Link;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Page<T> {

    @JsonProperty
    private List<Link> links = new ArrayList<Link>();

    @JsonProperty("content")
    private List<T> content = new ArrayList<T>();

    @JsonProperty("page")
    private PageMetadata page;

    public List<Link> getLinks() {
        return Collections.unmodifiableList(links);
    }

    public List<T> getContent() {
        return Collections.unmodifiableList(content);
    }

    public PageMetadata getPage() {
        return page;
    }
}
