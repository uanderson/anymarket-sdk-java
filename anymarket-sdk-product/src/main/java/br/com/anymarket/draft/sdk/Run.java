package br.com.anymarket.draft.sdk;

import br.com.anymarket.draft.sdk.feed.Feed;
import br.com.anymarket.draft.sdk.feed.MarkFeedAsReadResponse;
import br.com.anymarket.draft.sdk.product.ProductFeedClient;

import java.util.List;

public class Run {

    public static void main(String[] args) {
        System.setProperty("anymarket.token", "LG1441113778898R-1765602495");
        ProductFeedClient productFeedClient = new ProductFeedClient();
        List<Feed> productFeeds = productFeedClient.list();

        Feed feed = productFeeds.get(0);

        MarkFeedAsReadResponse markFeedAsReadResponse = productFeedClient.markAsRead(feed);

        System.out.println();

    }

}
