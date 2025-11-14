package com.pluralsight.BakeHouse05.Models;

public enum SideType {
    CUPCAKE("Cupcake", 3.99),
    COOKIE("Cookie", 2.99),
    BROWNIE("Brownie", 4.99);


    private final String display;
    private final double price;

    SideType(String display, double price) {
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
