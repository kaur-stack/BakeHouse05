package com.pluralsight.BakeHouse05.Models;

public enum DrinkFlavor {
    COFFEE("Coffee"),
    TEA("Tea"),
    MILK("Milk"),
    JUICE("Juice");

    private final String display;

    DrinkFlavor(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }
}
