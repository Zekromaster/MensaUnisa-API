package net.zekromaster.mensaunisa.api.serialization.common;

import io.vavr.collection.HashSet;
import net.zekromaster.mensaunisa.api.domain.MealTime;
import org.apache.commons.lang3.math.NumberUtils;

public final class MealTimeSerialization {

    private MealTimeSerialization() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static MealTime fromCode(int code) {
        return HashSet.of(MealTime.values())
            .find(mealTime -> mealTime.code() == code)
            .getOrElseThrow(() -> new IllegalArgumentException("Invalid code: " + code));
    }

    public static MealTime fromStringId(String stringId) {
        return HashSet.of(MealTime.values())
            .find(mealTime -> mealTime.toString().equals(stringId))
            .getOrElseThrow(() -> new IllegalArgumentException("Invalid stringId: " + stringId));
    }

    public static MealTime fromString(String stringId) {
        if (NumberUtils.isDigits(stringId)) {
            return fromCode(Integer.parseInt(stringId));
        } else {
            return fromStringId(stringId);
        }
    }

}
