package net.zekromaster.mensaunisa.api.serialization.common;

import io.vavr.collection.HashSet;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;
import net.zekromaster.mensaunisa.api.domain.ServingType;
import org.apache.commons.lang3.math.NumberUtils;

@UtilityClass
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ServingTypeSerialization {

    public ServingType fromCode(int code) {
        return HashSet.of(ServingType.values())
            .find(servingType -> servingType.code() == code)
            .getOrElseThrow(() -> new IllegalArgumentException("Invalid code: " + code));
    }

    public ServingType fromStringId(String stringId) {
        return HashSet.of(ServingType.values())
            .find(servingType -> servingType.toString().equals(stringId))
            .getOrElseThrow(() -> new IllegalArgumentException("Invalid stringId: " + stringId));

    }

    public ServingType fromString(String stringId) {
        if (NumberUtils.isDigits(stringId)) {
            return fromCode(Integer.parseInt(stringId));
        } else {
            return fromStringId(stringId);
        }
    }
}
