package br.com.anymarket.sdk.variation;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by marcio.scharam on 29/04/2016.
 */
public class VariationDeserializer extends JsonDeserializer<Map<String, String>> {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Map<String, String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        Map<String, String> variations = new HashMap<String, String>();

        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        Iterator<JsonNode> elements = node.elements();
        while (elements.hasNext())
        {
            Variation variation = mapper.readValue(elements.next().toString(), Variation.class);
            variations.put(variation.getType().getName(), variation.getValue());
        }
        return variations;
    }
}
