package com.pluralsight.BakeHouse05;

public enum DrinkSize {
    SMALL("Small", 1.99),
    MEDIUM("Medium", 2.99),
    LARGE("Large", 3.99);

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
