package net.zekromaster.mensaunisa.api.serialization.common;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@UtilityClass
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LocalDateSerialization {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    public String toString(java.time.LocalDate localDate) {
        return localDate.format(formatter);
    }

    public LocalDate fromString(String string) {
        return LocalDate.parse(string, formatter);
    }

}
