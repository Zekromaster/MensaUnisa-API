package net.zekromaster.mensaunisa.api.domain;

import java.time.LocalDate;

public record Meal(
  LocalDate date,
  MealTime time
) {

}
