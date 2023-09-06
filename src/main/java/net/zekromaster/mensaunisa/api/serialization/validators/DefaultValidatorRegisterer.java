package net.zekromaster.mensaunisa.api.serialization.validators;

import io.javalin.validation.JavalinValidation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.zekromaster.mensaunisa.api.domain.MealTime;
import net.zekromaster.mensaunisa.api.serialization.common.LocalDateSerialization;
import net.zekromaster.mensaunisa.api.serialization.common.MealTimeSerialization;

import java.time.LocalDate;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
final class DefaultValidatorRegisterer implements ValidatorRegisterer {

    @Override
    public void registerValidators() {
        JavalinValidation.register(
            LocalDate.class,
            LocalDateSerialization::fromString
        );

        JavalinValidation.register(
            MealTime.class,
            MealTimeSerialization::fromString
        );
    }

}
