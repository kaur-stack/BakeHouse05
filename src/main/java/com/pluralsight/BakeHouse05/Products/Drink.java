package com.pluralsight.BakeHouse05.Products;

import com.pluralsight.BakeHouse05.Models.DrinkFlavor;
import com.pluralsight.BakeHouse05.Models.DrinkSize;
import com.pluralsight.BakeHouse05.BaseRoom.Product;

/**
 * Drink: simple drink item with size and flavor.
 */
public class Drink extends Product {
    private final DrinkSize size;
    private final DrinkFlavor flavor;

    /**
     * Create a drink. Base price comes from size.
     * @param size the drink size
     * @param flavor the drink flavor
     */
    public Drink(DrinkSize size, DrinkFlavor flavor) {
        // calls the super class
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
