package br.com.anymarket.draft.sdk.feed;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

import static com.google.common.base.Preconditions.checkNotNull;

public class MarkFeedAsReadResponse {

    @JsonProperty("token")
    private UUID token;

    public MarkFeedAsReadResponse(UUID token) {
        checkNotNull(token, "Token must not be null");
        this.token = token;
    }

    public UUID getToken() {
        return token;
    }

}
