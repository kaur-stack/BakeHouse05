package com.pluralsight.BakeHouse05.Models;

public enum DrinkSize {
    SMALL("Small", 4.99),
    MEDIUM("Medium", 5.99),
    LARGE("Large", 6.99);

    private final String display;
    private final double price;

    DrinkSize(String display, double price) {
        this.display = display;
        this.price = price;
    }

    public String getDisplay() {
        return display;
    }
    public double getPrice() {
        return price;
    }
}
