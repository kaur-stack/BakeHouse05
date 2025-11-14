package com.pluralsight.BakeHouse05;

import com.pluralsight.BakeHouse05.Models.DrinkFlavor;
import com.pluralsight.BakeHouse05.Models.DrinkSize;
import com.pluralsight.BakeHouse05.Products.Drink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {

    @Test
    @DisplayName("Get drink size correctly")
    void getDrinkSizeCorrectly() {
        // Arrange
        DrinkSize expectedSize = DrinkSize.MEDIUM;

        // Act
        Drink drink = new Drink(expectedSize, DrinkFlavor.COFFEE);

        // Assert
        assertEquals(expectedSize, drink.getSize());
    }

    @Test
    @DisplayName("Get drink flavor correctly")
    void getDrinkFlavorCorrectly() {
        // Arrange
        DrinkFlavor expectedFlavor = DrinkFlavor.TEA;

        // Act
        Drink drink = new Drink(DrinkSize.SMALL, expectedFlavor);

        // Assert
        assertEquals(expectedFlavor, drink.getFlavor());
    }
}