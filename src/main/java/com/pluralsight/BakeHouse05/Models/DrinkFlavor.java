package com.pluralsight.BakeHouse05.Models;

public enum DrinkFlavor {
    COFFEE("☕ Coffee"),
    TEA("\uD83E\uDDCB Tea"),
    MILK("\uD83E\uDDCB Milk"),
    JUICE("\uD83E\uDDC3 Juice");

    private final String display;

    DrinkFlavor(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }
}
