package com.example.troopersapp.model;

/**
 * Created by lslopes on 18/11/2017.
 */

public enum Affiliation {

    GALACT_REPUBLIC(0),
    GALACTIC_EMPIRE(1),
    FIRST_ORDER(2);

    private final int value;

    Affiliation(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
