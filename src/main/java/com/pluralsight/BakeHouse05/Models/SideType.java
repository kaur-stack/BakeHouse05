package com.pluralsight.BakeHouse05.Models;

public enum SideType {
    CUPCAKE("\uD83E\uDDC1 Cupcake", 3.99),
    COOKIE("\uD83C\uDF6A Cookie", 2.99),
    BROWNIE("\uD83C\uDF6B Brownie", 4.99);


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
