package net.zekromaster.mensaunisa.api.serialization.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.LocalDate;
import net.zekromaster.mensaunisa.api.serialization.common.LocalDateSerialization;


final class LocalDateAdapter extends TypeAdapter<LocalDate> {

    @Override
    public void write(JsonWriter out, LocalDate value) throws IOException {
        out.value(LocalDateSerialization.toString(value));
    }

    @Override
    public LocalDate read(JsonReader in) throws IOException {
        if (in.peek() != JsonToken.STRING) {
            throw new IOException("Expected string");
        } else {
            return LocalDateSerialization.fromString(in.nextString());
        }
    }
}
