package net.zekromaster.mensaunisa.api.serialization.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class LocalDateSerialization {

    private LocalDateSerialization() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static String toString(LocalDate localDate) {
        return localDate.format(formatter);
    }

    public static LocalDate fromString(String string) {
        return LocalDate.parse(string, formatter);
    }

}
