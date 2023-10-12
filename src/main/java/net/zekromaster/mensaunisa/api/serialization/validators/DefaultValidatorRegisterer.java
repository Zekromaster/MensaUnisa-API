package net.zekromaster.mensaunisa.api.serialization.validators;

import io.javalin.validation.JavalinValidation;
import net.zekromaster.mensaunisa.api.domain.MealTime;
import net.zekromaster.mensaunisa.api.serialization.common.LocalDateSerialization;
import net.zekromaster.mensaunisa.api.serialization.common.MealTimeSerialization;

import java.time.LocalDate;

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
