package com.pluralsight.BakeHouse05;

import java.util.ArrayList;
import java.util.List;

public class Cake extends Product {
    private final CakeSize size;
    private final CakeType type;
    private final List<Topping> toppings;
    private String specialMessage;

    public Cake(CakeSize size, CakeType type) {
        super(size.getDisplay() + " " + type.getDisplay() + " Cake",
                size.getBasePrice());
        this.size = size;
        this.type = type;
        this.toppings = new ArrayList<>();
    }

    public CakeSize getSize() {
        return size;
    }

    public CakeType getType() {
        return type;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    protected List<Topping> getToppingsInternal() {
        return toppings;
    }

    // Also add a public getter if needed:
    public List<Topping> getToppingsList() {
        return new ArrayList<>(toppings);  // Return copy to prevent external modification
    }

    public void setSpecialMessage(String message) {
        this.specialMessage = message;
    }

    public boolean hasSpecialMessage() {
        return specialMessage != null && !specialMessage.trim().isEmpty();
    }

    public String getSpecialMessage() {
        return specialMessage;
    }

    @Override
    public double calculatePrice() {
        double total = basePrice;

        for (Topping topping : toppings) {
            total += topping.getPrice();
        }

        if (hasSpecialMessage()) {
            total += 5.00;
        }

        return total;
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");

        if (!toppings.isEmpty()) {
            sb.append("  Toppings:\n");
            for (Topping topping : toppings) {
                sb.append("    - ").append(topping.toString()).append("\n");
            }
        }

        if (hasSpecialMessage()) {
            sb.append("  Special Message: \"").append(specialMessage).append("\" (+$5.00)\n");
        }

        sb.append(String.format("  Price: $%.2f", calculatePrice()));

        return sb.toString();
    }

}
