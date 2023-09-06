package net.zekromaster.mensaunisa.api.domain;

import io.vavr.collection.HashSet;
import io.vavr.collection.Seq;
import io.vavr.collection.Set;
import io.vavr.collection.Traversable;

public record Menu (
  Meal time,
  Set<Serving> servings
) {

  public Menu(Meal time, Traversable<Serving> servings) {
    this(time, HashSet.ofAll(servings));
  }

  public Seq<Serving> servings(ServingType type) {
    return servings()
             .filter(d -> d.type().equals(type))
             .toList()
             .sortBy(Serving::name);
  }

}
