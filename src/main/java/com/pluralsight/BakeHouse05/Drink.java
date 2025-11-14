package com.pluralsight.BakeHouse05;

public class Drink extends Product {
    private final DrinkSize size;
    private final DrinkFlavor flavor;

    public Drink(DrinkSize size, DrinkFlavor flavor) {
        super(size.getDisplay() + " " + flavor.getDisplay(),
                size.getPrice());
        this.size = size;
        this.flavor = flavor;
    }

    public DrinkSize getSize() {
        return size;
    }

    public DrinkFlavor getFlavor() {
        return flavor;
    }


    @Override
    public double calculatePrice() {
        return basePrice;
    }

    @Override
    public String getDescription() {
        return String.format("%s - $%.2f", name, calculatePrice());
    }
}
