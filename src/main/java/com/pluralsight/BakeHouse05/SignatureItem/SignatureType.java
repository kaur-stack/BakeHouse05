package com.pluralsight.BakeHouse05.SignatureItem;

import com.pluralsight.BakeHouse05.Models.CakeSize;
import com.pluralsight.BakeHouse05.Models.CakeType;

public enum SignatureType {
    RED_VELVET_DELIGHT(
            "\uD83C\uDF70 Red Velvet Delight",
            "Red velvet cake with white chocolate covered strawberries and cream cheese filling",
            CakeSize.MEDIUM,
            CakeType.RED_VELVET
    ),
    DUBAI_CHOCOLATE_DREAM(
            "\uD83C\uDF6B Dubai Chocolate Dream",
            "Chocolate cake with pistachio filling and chocolate ganache topping",
            CakeSize.MEDIUM,
            CakeType.CHOCOLATE
    ),
    TIRAMISU_CLASSIC(
            "\uD83C\uDF80 Tiramisu Classic",
            "Coffee-infused layers with ladyfingers, custard, and cocoa",
            CakeSize.MEDIUM,
            CakeType.VANILLA
    );

    private final String name;
    private final String description;
    private final CakeSize defaultSize;
    private final CakeType baseType;

    SignatureType(String name, String description, CakeSize defaultSize, CakeType baseType) {
        this.name = name;
        this.description = description;
        this.defaultSize = defaultSize;
        this.baseType = baseType;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public CakeSize getDefaultSize() { return defaultSize; }
    public CakeType getBaseType() { return baseType; }
}
