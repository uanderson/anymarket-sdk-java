package br.com.anymarket.draft.sdk.product;


import br.com.anymarket.draft.sdk.feed.Feed;
import br.com.anymarket.draft.sdk.feed.MarkFeedAsReadRequest;
import br.com.anymarket.draft.sdk.feed.MarkFeedAsReadResponse;
import br.com.anymarket.sdk.http.HttpService;
import br.com.anymarket.sdk.http.Response;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public class ProductFeedClient extends HttpService {

    public ProductFeedClient() {
        super();
    }

    public List<Feed> list() {
        Response response = execute(get("/products/feeds"));
        return response.to(new TypeReference<List<Feed>>() {
        });
    }

    public MarkFeedAsReadResponse markAsRead(Feed feed) {
        MarkFeedAsReadRequest request = new MarkFeedAsReadRequest(feed.getToken());
        Response response = execute(put("/products/feeds/" + feed.getId(), request));
        return response.to(MarkFeedAsReadResponse.class);
    }
}
