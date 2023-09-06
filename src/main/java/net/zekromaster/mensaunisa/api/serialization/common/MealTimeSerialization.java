package net.zekromaster.mensaunisa.api.serialization.common;

import io.vavr.collection.HashSet;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;
import net.zekromaster.mensaunisa.api.domain.MealTime;
import org.apache.commons.lang3.math.NumberUtils;

@UtilityClass
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MealTimeSerialization {

    public MealTime fromCode(int code) {
        return HashSet.of(MealTime.values())
            .find(mealTime -> mealTime.code() == code)
            .getOrElseThrow(() -> new IllegalArgumentException("Invalid code: " + code));
    }

    public MealTime fromStringId(String stringId) {
        return HashSet.of(MealTime.values())
            .find(mealTime -> mealTime.toString().equals(stringId))
            .getOrElseThrow(() -> new IllegalArgumentException("Invalid stringId: " + stringId));
    }

    public MealTime fromString(String stringId) {
        if (NumberUtils.isDigits(stringId)) {
            return fromCode(Integer.parseInt(stringId));
        } else {
            return fromStringId(stringId);
        }
    }

}
