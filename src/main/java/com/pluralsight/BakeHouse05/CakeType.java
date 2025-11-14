package com.pluralsight.BakeHouse05;

public enum CakeType {
    VANILLA("Vanilla"),
    CHOCOLATE("Chocolate"),
    RED_VELVET("Red Velvet"),
    FRUIT("Fruit"),
    MOCHA("Mocha"),
    LEMON("Lemon");

    private final String display;

    CakeType(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }
}
