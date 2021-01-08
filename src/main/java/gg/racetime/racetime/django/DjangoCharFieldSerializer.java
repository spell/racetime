package gg.racetime.racetime.django;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Properly serializes Django CharField fields from Django models.
 */
public class DjangoCharFieldSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String value, JsonGenerator generator, SerializerProvider serializer) throws IOException {
        if (value == null || value.isEmpty()) {
            generator.writeNull();
        } else {
            generator.writeString(value);
        }
    }
}
