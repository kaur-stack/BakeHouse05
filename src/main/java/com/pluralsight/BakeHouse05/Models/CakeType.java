package com.pluralsight.BakeHouse05.Models;

public enum CakeType {
    VANILLA("\uD83C\uDF68 Vanilla"),
    CHOCOLATE("\uD83C\uDF6B Chocolate"),
    RED_VELVET("\uD83C\uDF6B Red Velvet"),
    FRUIT("\uD83E\uDD6D Fruit"),
    MOCHA("\uD83D\uDFE4 Mocha"),
    LEMON("\uD83C\uDF4B Lemon");

    private final String display;

    CakeType(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }
}
