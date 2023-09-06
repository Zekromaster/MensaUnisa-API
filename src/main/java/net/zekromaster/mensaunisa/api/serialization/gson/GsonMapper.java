package net.zekromaster.mensaunisa.api.serialization.gson;

import com.google.gson.GsonBuilder;
import io.javalin.json.JavalinGson;
import io.javalin.json.JsonMapper;
import io.vavr.gson.VavrGson;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.zekromaster.mensaunisa.api.domain.MealTime;
import net.zekromaster.mensaunisa.api.domain.ServingType;
import java.time.LocalDate;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public final class GsonMapper {

    public static final JsonMapper GSON = GsonMapper.create();

    private static JsonMapper create() {
        var gsonBuilder = new GsonBuilder();
        VavrGson.registerAll(gsonBuilder);
        gsonBuilder.registerTypeAdapter(
            LocalDate.class,
            new LocalDateAdapter()
        );
        gsonBuilder.registerTypeAdapter(
            MealTime.class,
            new MealTimeAdapter()
        );
        gsonBuilder.registerTypeAdapter(
            ServingType.class,
            new ServingTypeAdapter()
        );
        var gson = gsonBuilder.create();
        return new JavalinGson(gson);
    }
}
