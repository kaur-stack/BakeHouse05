package com.pluralsight.BakeHouse05.BaseRoom;

/**
 * Product: base class for cakes, drinks, and sides.
 */
public abstract class Product implements Price, Customizable {
    protected String name;
    protected double basePrice;

    /**
     * Create a product with a name and a base price.
     * @param name the product name shown to user
     * @param basePrice the starting price in dollars
     */
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

    /**
     * Calculate full price for this product (must be implemented).
     * @return total price in dollars
     */
    public abstract double calculatePrice();

    /**
     * Get a short text description for this product (must be implemented).
     * @return description string
     */
    public abstract String getDescription();

}
