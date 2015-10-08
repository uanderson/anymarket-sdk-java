package br.com.anymarket.product;

import br.com.anymarket.auth.CredentialsProvider;
import br.com.anymarket.auth.DefaultCredentialsProviderChain;
import br.com.anymarket.feed.Feed;
import br.com.anymarket.feed.MarkFeedAsReadRequest;
import br.com.anymarket.feed.MarkFeedAsReadResponse;
import br.com.anymarket.http.HttpService;
import br.com.anymarket.http.Response;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public class ProductFeedClient extends HttpService {

    public ProductFeedClient() {
        super();
    }

    public ProductFeedClient(CredentialsProvider credentialsProvider) {
        super(credentialsProvider);
    }

    public List<Feed> list() {
        Response response = execute(get("/products/feeds"));
        return response.to(new TypeReference<List<Feed>>() {});
    }


    public MarkFeedAsReadResponse markAsRead(Feed feed) {
        MarkFeedAsReadRequest request = new MarkFeedAsReadRequest(feed.getToken());
        Response response = execute(put("/products/feeds/" + feed.getId(), request));
        return response.to(MarkFeedAsReadResponse.class);
    }
}
