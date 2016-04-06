package br.com.anymarket.sdk.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.util.Objects.nonNull;

/**
 * Created by marcio.scharam on 05/04/2016.
 */
public class SDKDateSerializer extends JsonSerializer<Date> {

    public static final String FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXXs";

    @Override
    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        if (nonNull(value)) {
            jgen.writeString(new SimpleDateFormat(FORMAT).format(value));
        }
    }
}
