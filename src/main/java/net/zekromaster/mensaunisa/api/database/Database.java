package net.zekromaster.mensaunisa.api.database;

import io.vavr.collection.Traversable;
import io.vavr.control.Option;
import io.vavr.control.Try;
import net.zekromaster.mensaunisa.api.domain.Menu;
import net.zekromaster.mensaunisa.api.domain.Meal;

import java.time.LocalDate;

public interface Database {
  Try<Traversable<Menu>> all();

  Try<Menu> insert(Menu menu);

  default Try<Traversable<Menu>> getByDay(LocalDate day) {
    return this.all().map(all -> all.filter(menu -> menu.time().date().equals(day)));
  }

  default Try<Option<Menu>> getByTime(Meal meal) {
    return this.getByDay(meal.date()).map(meals -> meals.find(menu -> menu.time().equals(meal)));
  }

}
