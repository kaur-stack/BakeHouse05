package com.pluralsight.BakeHouse05.Models;

public enum CakeSize {
    SMALL("Small (6\")", 15.99),
    MEDIUM("Medium (9\")", 25.99),
    LARGE("Large (12\")", 35.99);

    private final String display;
    private final double basePrice;

    CakeSize(String display, double basePrice) {
        this.display = display;
        this.basePrice = basePrice;
    }

    public String getDisplay() {
        return display;
    }
    public double getBasePrice() {
        return basePrice;
    }
}
