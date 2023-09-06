package net.zekromaster.mensaunisa.api;

import io.javalin.Javalin;
import io.vavr.collection.List;
import net.zekromaster.mensaunisa.api.controller.DatabaseRestHandlers;
import net.zekromaster.mensaunisa.api.database.StubDatabase;
import net.zekromaster.mensaunisa.api.domain.*;
import net.zekromaster.mensaunisa.api.serialization.gson.GsonMapper;
import net.zekromaster.mensaunisa.api.serialization.validators.ValidatorRegisterer;

import java.time.LocalDate;

public class MensaUnisaAPI {

  public static void main(String[] args) {
    var database = new StubDatabase();

    var controller = new DatabaseRestHandlers(database);

    var app = Javalin.create(config ->
      config.jsonMapper(GsonMapper.GSON)
    );

    ValidatorRegisterer.DEFAULT.registerValidators();

    app
        .get("/meals", controller::getAll)
        .get("/meals/{day}", controller::getByDay)
        .get("/meals/{day}/{time}", controller::getByTime)
        .post("/meals", controller::insert)
        .start(7000);
  }

}