package com.pluralsight.BakeHouse05;

import com.pluralsight.BakeHouse05.Models.CakeSize;
import com.pluralsight.BakeHouse05.Models.CakeType;
import com.pluralsight.BakeHouse05.Products.Cake;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CakeTest {

    @Test
    @DisplayName("Cake should have correct base price")
    void cakeHasCorrectBasePrice() {
        // Arrange & Act
        Cake cake = new Cake(CakeSize.SMALL, CakeType.CHOCOLATE);
        double expectedPrice = CakeSize.SMALL.getBasePrice();

        // Assert
        assertEquals(expectedPrice, cake.calculatePrice(), 0.01);
    }

    @Test
    @DisplayName("Special message adds extra charge")
    void specialMessageAddsExtraCharge() {
        // Arrange
        Cake cake = new Cake(CakeSize.SMALL, CakeType.CHOCOLATE);
        double basePriceOnly = CakeSize.SMALL.getBasePrice();
        double expectedPriceWithMessage = basePriceOnly + 5.00;

        // Act
        cake.setSpecialMessage("Happy Birthday!");
        double actualPrice = cake.calculatePrice();

        // Assert
        assertEquals(expectedPriceWithMessage, actualPrice, 0.01);
    }

    @Test
    @DisplayName("Get cake size correctly")
    void getCakeSizeCorrectly() {
        // Arrange
        CakeSize expectedSize = CakeSize.MEDIUM;

        // Act
        Cake cake = new Cake(expectedSize, CakeType.CHOCOLATE);

        // Assert
        assertEquals(expectedSize, cake.getSize());
    }
}