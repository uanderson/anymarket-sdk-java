package br.com.anymarket.sdk.product.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static java.lang.String.format;


public class OriginDeserializer extends JsonDeserializer<Origin> {

    public static final String CAN_NOT_DESERIALIZE = "Can not deserialize instance of %s with value %s";

    @Override
    public Origin deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        final Integer id = node.get("id").asInt();
        for (final Origin origin : Origin.values()) {
            if (origin.getId().equals(id)) {
                return origin;
            }
        }
        throw new JsonMappingException(format(CAN_NOT_DESERIALIZE, Origin.class, id));
    }
}
