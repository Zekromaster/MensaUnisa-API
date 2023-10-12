package net.zekromaster.mensaunisa.api;

import io.javalin.Javalin;
import io.vavr.collection.HashSet;
import net.zekromaster.mensaunisa.api.controller.DatabaseRestHandlers;
import net.zekromaster.mensaunisa.api.database.StubDatabase;
import net.zekromaster.mensaunisa.api.domain.*;
import net.zekromaster.mensaunisa.api.serialization.gson.GsonMapper;
import net.zekromaster.mensaunisa.api.serialization.validators.ValidatorRegisterer;

import java.time.LocalDate;

public class MensaUnisaAPI {

  public static void main(String[] args) {
    var database = new StubDatabase(
        new Menu(
            new Meal(
                LocalDate.of(2020, 1, 1),
                MealTime.LUNCH
            ),
            HashSet.of(
                new Serving(ServingType.FIRST, "Pasta al pomodoro")
            )
        )
    );

    var controller = new DatabaseRestHandlers(database);

    var app = Javalin.create(config ->
      config.jsonMapper(GsonMapper.GSON)
    );

    ValidatorRegisterer.DEFAULT.registerValidators();

    controller.register(app).start(7000);
  }

}