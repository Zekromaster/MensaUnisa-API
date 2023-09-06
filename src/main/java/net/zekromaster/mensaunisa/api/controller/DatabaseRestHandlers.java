package net.zekromaster.mensaunisa.api.controller;

import io.javalin.http.Context;
import io.javalin.http.InternalServerErrorResponse;
import io.javalin.http.NotFoundResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.zekromaster.mensaunisa.api.database.Database;
import net.zekromaster.mensaunisa.api.domain.Meal;
import net.zekromaster.mensaunisa.api.domain.MealTime;
import net.zekromaster.mensaunisa.api.domain.Menu;

import java.time.LocalDate;
import java.util.function.Supplier;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public final class DatabaseRestHandlers implements RestHandlers {

    Database database;

    @Override
    public void getAll(Context ctx) {
        var menus = database.all();
        var response = menus.getOrElseThrow((Supplier<InternalServerErrorResponse>) InternalServerErrorResponse::new);
        ctx.json(response);
    }

    @Override
    public void getByDay(Context ctx) {
        var day = ctx.pathParamAsClass("day", LocalDate.class).get();
        var menus = database.getByDay(day);
        var response = menus.getOrElseThrow((Supplier<InternalServerErrorResponse>) InternalServerErrorResponse::new);

        if (response.isEmpty()) {
            throw new NotFoundResponse("No menus found for day " + day);
        }

        ctx.json(response.get());
    }

    @Override
    public void getByTime(Context ctx) {
        var day = ctx.pathParamAsClass("day", LocalDate.class).get();
        var time = ctx.pathParamAsClass("time", MealTime.class).get();

        var menus = database.getByTime(new Meal(day, time));
        var response = menus.getOrElseThrow((Supplier<InternalServerErrorResponse>) InternalServerErrorResponse::new);

        if (response.isEmpty()) {
            throw new NotFoundResponse("No menu found for day " + day + " at " + time);
        }

        ctx.json(response.get());
    }

    @Override
    public void insert(Context ctx) {
        var menu = ctx.bodyAsClass(Menu.class);
        var response = database.insert(menu);
        ctx.json(response.getOrElseThrow((Supplier<InternalServerErrorResponse>) InternalServerErrorResponse::new));
    }
}
