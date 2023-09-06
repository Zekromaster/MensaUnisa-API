package net.zekromaster.mensaunisa.api.database;

import io.vavr.collection.HashSet;
import io.vavr.collection.Traversable;
import io.vavr.control.Try;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import net.zekromaster.mensaunisa.api.domain.Menu;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class StubDatabase implements Database {

  @NonFinal HashSet<Menu> meals;

  public StubDatabase(Traversable<Menu> meals) {
    this.meals = HashSet.ofAll(meals);
  }

  public StubDatabase(Menu... menus) {
    this(HashSet.of(menus));
  }

  @Override
  public Try<Traversable<Menu>> all() {
    return Try.success(meals);
  }

  @Override
  public Try<Menu> insert(Menu menu) {
    meals = meals.add(menu);
    return Try.success(menu);
  }
}
