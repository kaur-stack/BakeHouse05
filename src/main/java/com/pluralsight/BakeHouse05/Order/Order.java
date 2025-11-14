package com.pluralsight.BakeHouse05.Order;

import com.pluralsight.BakeHouse05.BaseRoom.Product;
import com.pluralsight.BakeHouse05.Products.Cake;
import com.pluralsight.BakeHouse05.Products.Drink;
import com.pluralsight.BakeHouse05.Products.Side;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Order: list of products and order time.
 */
public class Order {
    private final List<Product> products;
    private final LocalDateTime orderTime;

    /**
     * Create a new empty order. Sets current time.
     */
    public Order() {
        this.products = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Add a product to this order.
     * @param product product to add
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Check if the order has no products.
     * @return true if empty
     */
    public boolean isEmpty() {
        return products.isEmpty();
    }

    /**
     * Basic order validation. Must have at least one item.
     * @return true if order is valid
     */
    public boolean isValid() {
        if (products.isEmpty()) {
            return false;
        }

        boolean hasCake = false;
        boolean hasOtherItem = false;

        for (Product product : products) {
            if (product instanceof Cake) {
                hasCake = true;
            } else {
                hasOtherItem = true;
            }
        }
        return hasCake || hasOtherItem;
    }

    public double calculateTotal() {
        double totalPrice = 0.0;

        for (Product product : products) {
            totalPrice += product.calculatePrice();
        }

        return totalPrice;
    }

    /**
     * Build a printable order summary for console display.
     * @return the order summary text
     */

    public String getOrderSummary() {
        StringBuilder descriptionBuilder = new StringBuilder();
        descriptionBuilder.append("========================================\n");
        descriptionBuilder.append("           BAKEHOUSE05 ORDER            \n");
        descriptionBuilder.append("========================================\n");
        descriptionBuilder.append("Order Time: ").append(orderTime.format(
                DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a"))).append("\n\n");

        // Group products by type for better display
        List<Cake> cakes = new ArrayList<>();
        List<Drink> drinks = new ArrayList<>();
        List<Side> sides = new ArrayList<>();

        for (Product product : products) {
            if (product instanceof Cake) {
                cakes.add((Cake) product);
            } else if (product instanceof Drink) {
                drinks.add((Drink) product);
            } else if (product instanceof Side) {
                sides.add((Side) product);
            }
        }

        if (!cakes.isEmpty()) {
            descriptionBuilder.append("CAKES:\n");
            for (int i = 0; i < cakes.size(); i++) {
                descriptionBuilder.append((i + 1)).append(". ");
                descriptionBuilder.append(cakes.get(i).getDescription()).append("\n\n");
            }
        }

        if (!drinks.isEmpty()) {
            descriptionBuilder.append("DRINKS:\n");
            for (int i = 0; i < drinks.size(); i++) {
                descriptionBuilder.append((i + 1)).append(". ");
                descriptionBuilder.append(drinks.get(i).getDescription()).append("\n");
            }
            descriptionBuilder.append("\n");
        }

        if (!sides.isEmpty()) {
            descriptionBuilder.append("SIDES:\n");
            for (int i = 0; i < sides.size(); i++) {
                descriptionBuilder.append((i + 1)).append(". ");
                descriptionBuilder.append(sides.get(i).getDescription()).append("\n");
            }
            descriptionBuilder.append("\n");
        }

        descriptionBuilder.append("----------------------------------------\n");
        descriptionBuilder.append(String.format("TOTAL: $%.2f\n", calculateTotal()));
        descriptionBuilder.append("========================================\n");
        descriptionBuilder.append("    Thank you for visiting Bakehouse05!  \n");
        descriptionBuilder.append("========================================\n");

        return descriptionBuilder.toString();
    }
}
