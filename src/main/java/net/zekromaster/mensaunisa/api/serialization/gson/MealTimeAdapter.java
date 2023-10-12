package net.zekromaster.mensaunisa.api.serialization.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import net.zekromaster.mensaunisa.api.domain.MealTime;
import net.zekromaster.mensaunisa.api.serialization.common.MealTimeSerialization;

final class MealTimeAdapter extends TypeAdapter<MealTime> {

    @Override
    public void write(JsonWriter out, MealTime value) throws IOException {
        out.value(value.toString());
    }

    @Override
    public MealTime read(JsonReader in) throws IOException {
        return switch (in.peek()) {
            case STRING -> MealTimeSerialization.fromString(in.nextString());
            case NUMBER -> MealTimeSerialization.fromCode(in.nextInt());
            default -> throw new IOException("Expected string or number");
        };
    }
}
