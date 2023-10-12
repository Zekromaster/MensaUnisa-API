package net.zekromaster.mensaunisa.api.serialization.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import net.zekromaster.mensaunisa.api.domain.ServingType;
import net.zekromaster.mensaunisa.api.serialization.common.ServingTypeSerialization;

final class ServingTypeAdapter extends TypeAdapter<ServingType> {

    @Override
    public void write(JsonWriter out, ServingType value) throws IOException {
        out.value(value.toString());
    }

    @Override
    public ServingType read(JsonReader in) throws IOException {
        return switch (in.peek()) {
            case STRING -> ServingTypeSerialization.fromString(in.nextString());
            case NUMBER -> ServingTypeSerialization.fromCode(in.nextInt());
            default -> throw new IOException("Expected string or number");
        };
    }
}
