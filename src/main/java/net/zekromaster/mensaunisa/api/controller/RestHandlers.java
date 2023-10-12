package net.zekromaster.mensaunisa.api.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;

public interface RestHandlers {

    void getAll(Context ctx);

    void getByDay(Context ctx);

    void getByTime(Context ctx);

    void insert(Context ctx);

    default Javalin register(Javalin app) {
        return app
            .get("/meals", this::getAll)
            .get("/meals/{day}", this::getByDay)
            .get("/meals/{day}/{time}", this::getByTime)
            .post("/meals", this::insert);
    }

}
