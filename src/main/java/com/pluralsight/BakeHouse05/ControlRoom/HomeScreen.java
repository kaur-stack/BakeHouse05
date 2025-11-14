package com.pluralsight.BakeHouse05.ControlRoom;

import com.pluralsight.BakeHouse05.BaseRoom.Topping;
import com.pluralsight.BakeHouse05.Order.Order;
import com.pluralsight.BakeHouse05.Order.ReceiptsFileManager;
import com.pluralsight.BakeHouse05.Models.*;
import com.pluralsight.BakeHouse05.Products.Cake;
import com.pluralsight.BakeHouse05.Products.Drink;
import com.pluralsight.BakeHouse05.Products.Side;
import com.pluralsight.BakeHouse05.SignatureItem.SignatureCake;
import com.pluralsight.BakeHouse05.SignatureItem.SignatureType;
import com.pluralsight.BakeHouse05.Interface.Display;

import java.util.List;
import java.util.Scanner;

import static com.pluralsight.BakeHouse05.ControlRoom.ToppingMenu.*;
import static com.pluralsight.BakeHouse05.ControlRoom.ToppingMenu.addPremiumFillings;

public class HomeScreen {
    private static Order currentOrder;
    private static final ReceiptsFileManager receiptsFileManager = new ReceiptsFileManager();

    public static void showHomeScreen() {
        Display.displayWelcome();

        boolean endProgram = true;

        while (endProgram) {
            Display.displayHomeScreen();

            int userChoice = ValidUserInput.getIntChoice("➡ Enter your choice: ", 0, 1);

            switch (userChoice) {
                case 1:
                    currentOrder = new Order();
                    System.out.println("\n\uD83C\uDD95 New order started!");
                    showOrderScreen();
                    break;
                case 0:
                    endProgram = false;
                    break;
            }
        }
    }

    private static void showOrderScreen() {
        boolean orderInProcess = true;

        while (orderInProcess) {
            Display.displayOrderScreen();

            int choice = ValidUserInput.getIntChoice("➡ Enter your choice: ", 0, 5);

            switch (choice) {
                case 1:
                    addCake();
                    break;
                case 2:
                    addSignatureCake();
                    break;
                case 3:
                    addDrink();
                    break;
                case 4:
                    addSide();
                    break;
                case 5:
                    orderInProcess = !checkout();
                    break;
                case 0:
                    if (ValidUserInput.getYesNo("\uD83D\uDEA8 Are you sure you want to cancel this order?")) {
                        System.out.println("\n⛔ Order cancelled.");
                        currentOrder = null;
                        orderInProcess = false;
                    }
                    break;
            }
        }
    }

    private static void addCake() {
        System.out.println("\n========== \uD83C\uDF70 CUSTOMIZE YOUR CAKE \uD83C\uDF70 ==========\n");

        System.out.println("\uD83C\uDFAF Select cake flavor:");
        CakeType[] types = CakeType.values();
        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ") " + types[i].getDisplay());
        }
        int typeChoice = ValidUserInput.getIntChoice("\uD83D\uDCCC Choice: ", 1, types.length);
        CakeType userPickedType = types[typeChoice - 1];

        System.out.println("\n \uD83C\uDFAF Select cake size:");
        CakeSize[] sizes = CakeSize.values();
        for (int i = 0; i < sizes.length; i++) {
            System.out.printf("%d) %s - $%.2f\n", (i + 1),
                    sizes[i].getDisplay(), sizes[i].getBasePrice());
        }
        int sizesChoice = ValidUserInput.getIntChoice("\uD83D\uDCCC Choice: ", 1, sizes.length);
        CakeSize userPickedSize = sizes[sizesChoice - 1];

        Cake cake = new Cake(userPickedSize, userPickedType);

        System.out.println("\n--- \uD83C\uDF6F TOPPINGS \uD83C\uDF6F ---");

        System.out.println("\n===== \uD83C\uDF70 ADD FILLINGS \uD83C\uDF70 =====");
        ToppingMenu.addRegularFillings(cake);
        ToppingMenu.addPremiumFillings(cake);

        // Step 4: Add TOPPINGS (Regular and Premium)
        System.out.println("\n===== \uD83C\uDF53 ADD TOPPINGS \uD83C\uDF53 =====");
        ToppingMenu.addRegularToppings(cake);
        ToppingMenu.addPremiumToppings(cake);

        // Step 5: Special message option
        System.out.println("\n===== ✨ SPECIAL OPTION ✨ =====");
        if (ValidUserInput.getYesNo("Would you like a custom message printed on the cake? (+$5.00)")) {
            addSpecialMessageToCake(cake);
        }

        currentOrder.addProduct(cake);
        System.out.println("\n✅ Cake added to order!");
        System.out.printf("  This cake costs: $%.2f\n", cake.calculatePrice());
    }

    private static void addDrink() {
        System.out.println("\n========== \uD83C\uDF79 ADD DRINK \uD83E\uDD42 ==========\n");

        System.out.println("☕ Select drink flavor:");
        DrinkFlavor[] flavors = DrinkFlavor.values();
        for (int i = 0; i < flavors.length; i++) {
            System.out.println((i + 1) + ") " + flavors[i].getDisplay());
        }

        int flavorChoice = ValidUserInput.getIntChoice("\uD83D\uDCCC Choice: ", 1, flavors.length);
        DrinkFlavor userPickedFlavor = flavors[flavorChoice - 1];

        System.out.println("\n \uD83C\uDFAF Select Size:");
        DrinkSize[] sizes = DrinkSize.values();
        for (int i = 0; i < sizes.length; i++) {
            System.out.printf("%d) %s - $%.2f\n", (i + 1), sizes[i].getDisplay(), sizes[i].getPrice());
        }

        int sizeChoice = ValidUserInput.getIntChoice("\uD83D\uDCCC Choice: ", 1, sizes.length);
        DrinkSize userPickedSize = sizes[sizeChoice - 1];

        Drink drink = new Drink(userPickedSize, userPickedFlavor);

        currentOrder.addProduct(drink);

        System.out.println("\n\uD83E\uDD42 Drink added to order!");
        System.out.printf("  Price: $%.2f\n", drink.calculatePrice());
    }

    private static void addSide() {
        System.out.println("\n========== \uD83C\uDF6A ADD SIDE \uD83C\uDF6A ==========\n");

        System.out.println("\uD83C\uDFAF Select a side:");
        SideType[] types = SideType.values();
        for (int i = 0; i < types.length; i++) {
            System.out.printf("%d) %s - $%.2f\n", (i + 1),
                    types[i].getDisplay(), types[i].getPrice());
        }
        int sideChoice = ValidUserInput.getIntChoice("\uD83D\uDCCC Choice: ", 1, types.length);
        SideType userPickedType = types[sideChoice - 1];

        Side side = new Side(userPickedType);

        // POLYMORPHISM: Adding a Side as a Product
        currentOrder.addProduct(side);

        System.out.println("\n✅ Side added to order!");
        System.out.printf("  Price: $%.2f\n", side.calculatePrice());
    }

    private static boolean checkout() {
        System.out.println("\n========== \uD83D\uDED2 CHECKOUT \uD83D\uDED2 ==========\n");

        if (currentOrder.isEmpty()) {
            System.out.println("\uD83E\uDEAB Your order is empty! Please add at least one item.");
            return false;
        }

        if (!currentOrder.isValid()) {
            System.out.println("\uD83D\uDEA8 If you don't order a cake, you must add at least a drink or side!");
            return false;
        }

        System.out.println(currentOrder.getOrderSummary());

        if (ValidUserInput.getYesNo("\nConfirm this order?")) {
            receiptsFileManager.generateReceipt(currentOrder);
            System.out.println("\n✅ Order completed! Enjoy your treats! 🍰");
            currentOrder = null;
            ValidUserInput.waitForEnter();
            return true;
        } else {
            System.out.println("\n❌Order not confirmed. Returning to order screen...");
            return false;
        }
    }

    // Handle Signature Order:
    public static void addSignatureCake() {
        System.out.println("\n========== SIGNATURE CAKES ==========\n");
        System.out.println("\uD83D\uDC69\uD83C\uDFFB\u200D\uD83C\uDF73 Our chef's special pre-designed cakes!");
        System.out.println("\uD83C\uDF7D\uFE0F You can still customize by adding or removing toppings.\n");

        SignatureType[] types = SignatureType.values();
        for (int i = 0; i < types.length; i++) {
            System.out.printf("%d) %s\n", (i + 1), types[i].getName());
            System.out.printf("   %s\n", types[i].getDescription());
            System.out.printf("   Default size: %s - Starting at $%.2f\n\n",
                    types[i].getDefaultSize().getDisplay(),
                    types[i].getDefaultSize().getBasePrice());
        }
        System.out.println("\uD83D\uDD34 0) Go back");

        int userChoice = ValidUserInput.getIntChoice("\uD83D\uDCE7 Select a signature cake: ", 0, types.length);

        if (userChoice == 0) {
            return;  // Go back to order screen
        }

        SignatureType selectedType = types[userChoice - 1];

        System.out.println("\nDefault size is " + selectedType.getDefaultSize().getDisplay());
        boolean changeSize = ValidUserInput.getYesNo("\uD83D\uDD0E Would you like a different size?");

        SignatureCake cake;
        if (changeSize) {
            System.out.println("\n \uD83C\uDFAF Select size:");
            CakeSize[] sizes = CakeSize.values();
            for (int i = 0; i < sizes.length; i++) {
                System.out.printf("%d) %s - $%.2f\n", (i + 1),
                        sizes[i].getDisplay(), sizes[i].getBasePrice());
            }
            int sizeChoice = ValidUserInput.getIntChoice("\uD83D\uDCCC  Choice: ", 1, sizes.length);
            CakeSize selectedSize = sizes[sizeChoice - 1];
            cake = new SignatureCake(selectedType, selectedSize);
        } else {
            cake = new SignatureCake(selectedType);
        }

        // Show current toppings
        System.out.println("\n===== ⭐ YOUR SIGNATURE CAKE ⭐=====");
        System.out.println(cake.getDescription());

        // Customization
        boolean customizing = true;
        while (customizing) {
            System.out.println("\n===== CUSTOMIZE YOUR SIGNATURE CAKE =====");
            System.out.println("\uD83D\uDEAB 1) Remove a topping/filling");
            System.out.println("\uD83C\uDF38 2) Add more toppings/fillings");
            System.out.println("\uD83D\uDCDC 3) Add special message (+$5.00)");
            System.out.println("4) Finish and add to order");
            System.out.println("=========================================");

            int customChoice = ValidUserInput.getIntChoice("\uD83D\uDCCC Choice: ", 1, 4);

            switch (customChoice) {
                case 1:
                    removeSignatureCakeTopping(cake);
                    break;
                case 2:
                    addSignatureCakeToppings(cake);
                    break;
                case 3:
                    if (!cake.hasSpecialMessage()) {
                        addSpecialMessageToCake(cake);
                    } else {
                        System.out.println("\uD83D\uDCE7 Special message already added: \"" + cake.getSpecialMessage() + "\"");
                        if (ValidUserInput.getYesNo("\uD83D\uDD0E Would you like to change it?")) {
                            addSpecialMessageToCake(cake);
                        }
                    }
                    break;
                case 4:
                    customizing = false;
                    break;
            }

            if (customizing) {
                System.out.println("\n" + cake.getDescription());
            }
        }

        // Add to order (POLYMORPHISM - SignatureCake is a Product)
        currentOrder.addProduct(cake);
        System.out.println("\n✅ Signature cake added to order!");
        System.out.printf("  Total price: $%.2f\n", cake.calculatePrice());


    }

    private static void removeSignatureCakeTopping(SignatureCake cake) {
        List<Topping> toppings = cake.getToppingsList();

        if (toppings.isEmpty()) {
            System.out.println("\n❌ No toppings to remove!");
            return;
        }

        System.out.println("\n===== \n\uD83C\uDF6F\uD83C\uDF53 CURRENT TOPPINGS/FILLINGS \n\uD83C\uDF6F\uD83C\uDF53 =====");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.printf("%d) %s\n", (i + 1), toppings.get(i).getName());
        }
        System.out.println("\uD83D\uDD34 0) Cancel");

        int choice = ValidUserInput.getIntChoice("\uD83C\uDFAF Select topping to remove: ", 0, toppings.size());

        if (choice > 0) {
            String toppingName = toppings.get(choice - 1).getName();
            if (cake.removeTopping(toppingName)) {
                System.out.println("✅ Removed " + toppingName);
            } else {
                System.out.println("❌ Failed to remove topping");
            }
        }
    }

    private static void addSignatureCakeToppings(SignatureCake cake) {
        System.out.println("\n\uD83C\uDF6F\uD83C\uDF53 You can add any additional toppings or fillings!");

        boolean adding = true;
        while (adding) {
            System.out.println("\uD83C\uDF53 1) Add regular toppings (FREE)");
            System.out.println("✨ 2) Add premium toppings (\uD83D\uDCB8+$2.00 each)");
            System.out.println("\uD83C\uDF6F 3) Add regular fillings (FREE)");
            System.out.println("✨ 4) Add premium fillings (\uD83D\uDCB8+$2.00 each)");
            System.out.println("\uD83D\uDED1 0) Done adding");

            int choice = ValidUserInput.getIntChoice("Choice: ", 0, 4);

            switch (choice) {
                case 1:
                    addRegularToppings(cake);
                    break;
                case 2:
                    addPremiumToppings(cake);
                    break;
                case 3:
                    addRegularFillings(cake);
                    break;
                case 4:
                    addPremiumFillings(cake);
                    break;
                case 0:
                    adding = false;
                    break;
            }
        }
    }

    public static void addSpecialMessageToCake(Cake cake) {
        System.out.println("\n===== \uD83D\uDC8C SPECIAL MESSAGE \uD83D\uDC8C =====");
        System.out.println("\uD83D\uDCDC You can add a custom message or request a photo to be printed on the cake.");
        System.out.println("\uD83D\uDCB8 Cost: +$5.00");
        System.out.println();
        System.out.print("\uD83D\uDCAC Enter your message (or type 'cancel' to skip): ");

        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine().trim();

        if (message.equalsIgnoreCase("cancel") || message.isEmpty()) {
            System.out.println("❌ Special message cancelled.");
            return;
        }

        // Set the message
        cake.setSpecialMessage(message);
        System.out.println("✅ Special message added: \"" + message + "\"");
        System.out.println("  (+$5.00)");
    }
}
