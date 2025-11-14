package com.pluralsight.BakeHouse05.SignatureItem;

import com.pluralsight.BakeHouse05.Products.Cake;
import com.pluralsight.BakeHouse05.Models.CakeSize;
import com.pluralsight.BakeHouse05.BaseRoom.Topping;
import com.pluralsight.BakeHouse05.Models.ToppingCategory;

import java.util.List;

public class SignatureCake extends Cake {
    private final SignatureType signatureType;
    private boolean isCustomized;

    public SignatureCake(SignatureType signatureType) {
        // Call parent Cake constructor with default size and base type
        super(signatureType.getDefaultSize(), signatureType.getBaseType());
        this.signatureType = signatureType;
        this.isCustomized = false;

        // Add the signature toppings/fillings for this cake
        addSignatureToppings();
    }

    public SignatureCake(SignatureType signatureType, CakeSize customSize) {
        // Call parent Cake constructor with custom size
        super(customSize, signatureType.getBaseType());
        this.signatureType = signatureType;
        this.isCustomized = false;

        // Add the signature toppings/fillings for this cake
        addSignatureToppings();
    }

    // Adds the pre-defined toppings/fillings based on signature type
    private void addSignatureToppings() {
        switch (signatureType) {
            case RED_VELVET_DELIGHT:
                // Cream Cheese Filling (Premium)
                super.addTopping(new Topping("Cream Cheese Filling", ToppingCategory.PREMIUM, false));
                // White Chocolate Covered Strawberries (Premium, treated as topping)
                super.addTopping(new Topping("White Chocolate Strawberries", ToppingCategory.PREMIUM, false));
                // Buttercream base (Regular)
                super.addTopping(new Topping("Buttercream", ToppingCategory.REGULAR, false));
                break;

            case DUBAI_CHOCOLATE_DREAM:
                // Pistachio Cream Filling (Premium)
                super.addTopping(new Topping("Pistachio Cream", ToppingCategory.PREMIUM, false));
                // Chocolate Ganache Topping (Regular)
                super.addTopping(new Topping("Chocolate Ganache", ToppingCategory.REGULAR, false));
                // Dubai Chocolate pieces (Premium)
                super.addTopping(new Topping("Dubai Chocolate", ToppingCategory.PREMIUM, false));
                break;

            case TIRAMISU_CLASSIC:
                // Custard Filling (Regular)
                super.addTopping(new Topping("Custard", ToppingCategory.REGULAR, false));
                // Mocha Cream (Regular - for coffee flavor)
                super.addTopping(new Topping("Mocha Cream", ToppingCategory.REGULAR, false));
                // Cocoa Powder (represented as topping)
                super.addTopping(new Topping("Cocoa Powder", ToppingCategory.REGULAR, false));
                break;
        }
    }

    @Override
    public void addTopping(Topping topping) {
        super.addTopping(topping);
        isCustomized = true;
    }

    public boolean removeTopping(String toppingName) {
        List<Topping> toppings = getToppings();

        // Find and remove the topping
        for (int i = 0; i < toppings.size(); i++) {
            if (toppings.get(i).getName().equalsIgnoreCase(toppingName)) {
                toppings.remove(i);
                isCustomized = true;
                return true;
            }
        }

        return false;  // Topping not found
    }

    private List<Topping> getToppings() {
        // This assumes we add a getToppings() method to the Cake class
        // For now, we'll use reflection or provide a workaround
        return super.getToppingsInternal();
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();

        // Show signature name prominently
        sb.append("⭐ ").append(signatureType.getName());
        if (isCustomized) {
            sb.append(" (Customized\uD83D\uDCAC)");
        }
        sb.append("\n");

        // Show size and base type
        sb.append("   ").append(getSize().getDisplay()).append(" | ");
        sb.append(getType().getDisplay()).append("\n");

        // Show toppings
        List<Topping> toppings = getToppings();
        if (!toppings.isEmpty()) {
            sb.append("  \uD83C\uDF52 Toppings & Fillings:\n");
            for (Topping topping : toppings) {
                sb.append("    - ").append(topping.toString()).append("\n");
            }
        }

        // Special message
        if (hasSpecialMessage()) {
            sb.append("  \uD83D\uDCDC Special Message: Yes (+$5.00)\n");
        }

        sb.append(String.format("  \uD83D\uDCB8 Price: $%.2f", calculatePrice()));

        return sb.toString();
    }

    public SignatureType getSignatureType() { return signatureType; }
    public boolean isCustomized() { return isCustomized; }
}
