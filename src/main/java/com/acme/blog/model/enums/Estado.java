package com.acme.blog.model.enums;

public enum Estado {

    ELIMINADO(0),
    NO_ELIMINADO(1);

    private final int value;

    Estado(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
