package net.zekromaster.mensaunisa.api.controller;

import io.javalin.http.Context;

public interface RestHandlers {

    void getAll(Context ctx);

    void getByDay(Context ctx);

    void getByTime(Context ctx);

    void insert(Context ctx);

}
