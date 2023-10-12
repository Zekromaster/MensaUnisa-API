package net.zekromaster.mensaunisa.api.domain;

public enum ServingType {
    FIRST(1, "first"),
    SECOND(2, "second"),
    SIDE(3, "side"),
    SINGLE(4, "single"),
    SALAD(5, "salad");

    private final int code;
    private final String toString;

    ServingType(int code, String toString) {
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
