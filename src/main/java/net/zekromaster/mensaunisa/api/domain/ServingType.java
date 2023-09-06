package net.zekromaster.mensaunisa.api.domain;

import io.vavr.control.Try;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.math.NumberUtils;

@AllArgsConstructor
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum ServingType {
    FIRST(1, "first"),
    SECOND(2, "second"),
    SIDE(3, "side"),
    SINGLE(4, "single"),
    SALAD(5, "salad");

    private final int code;
    private final String toString;

}
