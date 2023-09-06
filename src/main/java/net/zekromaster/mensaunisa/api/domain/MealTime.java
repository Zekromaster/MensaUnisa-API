package net.zekromaster.mensaunisa.api.domain;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum MealTime {
    LUNCH(0, "lunch"),
    DINNER(1, "dinner");

    int code;
    String toString;
}
