package net.zekromaster.mensaunisa.api.serialization.gson;

import com.google.gson.GsonBuilder;
import io.javalin.json.JavalinGson;
import io.javalin.json.JsonMapper;
import io.vavr.gson.VavrGson;
import net.zekromaster.mensaunisa.api.domain.MealTime;
import net.zekromaster.mensaunisa.api.domain.ServingType;
import java.time.LocalDate;

public final class GsonMapper {

    private GsonMapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

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
