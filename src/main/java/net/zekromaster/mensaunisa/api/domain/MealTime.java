package net.zekromaster.mensaunisa.api.domain;

public enum MealTime {
    LUNCH(0, "lunch"),
    DINNER(1, "dinner");

    private final int code;
    private final String toString;

    MealTime(int code, String toString) {
        this.code = code;
        this.toString = toString;
    }

    public int code() {
        return code;
    }

    @Override
    public String toString() {
        return toString;
    }
}
