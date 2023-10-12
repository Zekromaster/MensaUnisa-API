package net.zekromaster.mensaunisa.api.serialization.common;

import io.vavr.collection.HashSet;
import net.zekromaster.mensaunisa.api.domain.ServingType;
import org.apache.commons.lang3.math.NumberUtils;

public final class ServingTypeSerialization {

    private ServingTypeSerialization() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static ServingType fromCode(int code) {
        return HashSet.of(ServingType.values())
            .find(servingType -> servingType.code() == code)
            .getOrElseThrow(() -> new IllegalArgumentException("Invalid code: " + code));
    }

    public static  ServingType fromStringId(String stringId) {
        return HashSet.of(ServingType.values())
            .find(servingType -> servingType.toString().equals(stringId))
            .getOrElseThrow(() -> new IllegalArgumentException("Invalid stringId: " + stringId));

    }

    public static  ServingType fromString(String stringId) {
        if (NumberUtils.isDigits(stringId)) {
            return fromCode(Integer.parseInt(stringId));
        } else {
            return fromStringId(stringId);
        }
    }
}
