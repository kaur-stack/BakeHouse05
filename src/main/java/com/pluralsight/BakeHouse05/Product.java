package com.pluralsight.BakeHouse05;

public abstract class Product implements Price, Customizable{
    protected String name;
    protected double basePrice;

    public Product(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public abstract double calculatePrice();

    public abstract String getDescription();

}
