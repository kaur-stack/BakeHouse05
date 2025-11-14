package com.pluralsight.BakeHouse05;

public class Side extends Product {
    private final SideType type;

    public Side(SideType type) {
        super(type.getDisplay(), type.getPrice());
        this.type = type;
    }

    public SideType getType() {
        return type;
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
