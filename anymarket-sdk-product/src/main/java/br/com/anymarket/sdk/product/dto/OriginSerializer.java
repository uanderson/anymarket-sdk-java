package br.com.anymarket.sdk.product.dto;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcio.scharam on 19/04/2016.
 */
public class OriginSerializer extends JsonSerializer<Origin> {

//    public static final String CAN_NOT_SERIALIZE = "Can not serialize instance of %s with value %s";

    @Override
    public void serialize(Origin value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", value.getId());
        map.put("name", value.name());
        jsonGenerator.writeObject(map);
    }
}
