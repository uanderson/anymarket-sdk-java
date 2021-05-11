package br.com.anymarket.draft.sdk.feed;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import java.util.UUID;

public class Feed {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("token")
    private UUID token;

    public Long getId() {
        return id;
    }

    public UUID getToken() {
        return token;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other instanceof Feed) {
            Feed that = (Feed) other;
            return Objects.equal(id, that.id);
        }

        return false;
    }
}
