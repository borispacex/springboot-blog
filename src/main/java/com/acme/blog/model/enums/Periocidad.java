package com.acme.blog.model.enums;

public enum Periocidad {

    DIARIA(1),
    SEMANAL(2),
    MENSUAL(3);

    private final int value;

    Periocidad(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
