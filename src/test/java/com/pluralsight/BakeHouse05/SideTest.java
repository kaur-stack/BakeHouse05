package com.pluralsight.BakeHouse05;

import com.pluralsight.BakeHouse05.Models.SideType;
import com.pluralsight.BakeHouse05.Products.Side;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SideTest {

    @Test
    @DisplayName("Side should have correct price from type")
    void sideShouldHaveCorrectPrice() {
        // Arrange
        SideType type = SideType.COOKIE;
        double expectedPrice = type.getPrice();

        // Act
        Side side = new Side(type);
        double actualPrice = side.calculatePrice();

        // Assert
        assertEquals(expectedPrice, actualPrice, 0.01);
    }

    @Test
    @DisplayName("Get side type correctly")
    void getSideTypeCorrectly() {
        // Arrange
        SideType expectedType = SideType.CUPCAKE;

        // Act
        Side side = new Side(expectedType);

        // Assert
        assertEquals(expectedType, side.getType());
    }

    @Test
    @DisplayName("Calculate price returns base price")
    void calculatePriceReturnsBasePrice() {
        // Arrange
        Side side = new Side(SideType.BROWNIE);
        double basePrice = SideType.BROWNIE.getPrice();

        // Act
        double calculatedPrice = side.calculatePrice();

        // Assert
        assertEquals(basePrice, calculatedPrice, 0.01);
    }
}