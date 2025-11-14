package com.pluralsight.BakeHouse05;

import com.pluralsight.BakeHouse05.Order.Order;
import com.pluralsight.BakeHouse05.Models.CakeSize;
import com.pluralsight.BakeHouse05.Models.CakeType;
import com.pluralsight.BakeHouse05.Products.Cake;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    @DisplayName("New order should be empty")
    void isEmpty() {
        // Arrange & Act
        Order order = new Order();

        // Assert
        assertTrue(order.isEmpty());
    }

    @Test
    @DisplayName("Order should not be empty after adding product")
    void orderNotEmptyAfterAddingProduct() {
        // Arrange
        Order order = new Order();
        Cake cake = new Cake(CakeSize.SMALL, CakeType.CHOCOLATE);

        // Act
        order.addProduct(cake);

        // Assert
        assertFalse(order.isEmpty());
    }

    @Test
    @DisplayName("Empty order should not be valid")
    void emptyOrderIsNotValid() {
        // Arrange
        Order order = new Order();

        // Act
        boolean isValid = order.isValid();

        // Assert
        assertFalse(isValid);
    }

    @Test
    @DisplayName("Calculate total with one cake")
    void calculateTotalWithOneCake() {
        // Arrange
        Order order = new Order();
        Cake cake = new Cake(CakeSize.SMALL, CakeType.CHOCOLATE);
        double expectedTotal = CakeSize.SMALL.getBasePrice();

        // Act
        order.addProduct(cake);
        double actualTotal = order.calculateTotal();

        // Assert
        assertEquals(expectedTotal, actualTotal, 0.01);
    }
}