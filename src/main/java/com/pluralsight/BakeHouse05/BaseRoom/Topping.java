package com.pluralsight.BakeHouse05.BaseRoom;

import com.pluralsight.BakeHouse05.Models.ToppingCategory;

public class Topping {
    private final String name;
    private final ToppingCategory category;
    private final boolean isExtra;

    public Topping(String name, ToppingCategory category, boolean isExtra) {
        this.name = name;
        this.category = category;
        this.isExtra = isExtra;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        if (category == ToppingCategory.REGULAR) {
            return isExtra ? 1.50 : 0.00;
        } else {
            // Premium toppings/fillings cost $2.00 each
            // Extra premium costs an additional $1.50
            return isExtra ? 3.50 : 2.00;
        }
    }

    @Override
    public String toString() {
        String result = name;

        // Build the description based on category and extra status
        if (category == ToppingCategory.REGULAR) {
            // Regular toppings are free, but extra costs $1.50
            if (isExtra) {
                result += " (Extra) +$1.50";
            } else {
                result += " - FREE";
            }
        } else {
            // Premium toppings cost money
            if (isExtra) {
                // Show both premium and extra charges
                result += " (Premium + Extra) +$3.50";
            } else {
                result += " (Premium) +$2.00";
            }
        }

        return result;
    }
}
