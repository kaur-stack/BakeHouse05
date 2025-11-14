package com.pluralsight.BakeHouse05.ControlRoom;

import com.pluralsight.BakeHouse05.BaseRoom.Topping;
import com.pluralsight.BakeHouse05.Models.ToppingCategory;
import com.pluralsight.BakeHouse05.Products.Cake;

public class ToppingMenu {
    // ===== REGULAR FILLINGS MENU =====
    public static void addRegularFillings(Cake cake) {
        boolean addingFillings = true;

        while (addingFillings) {
            System.out.println("\n========== \uD83C\uDF70 REGULAR FILLINGS (FREE) ==========");
            System.out.println("\uD83C\uDF66 1) Vanilla Cream");
            System.out.println("\uD83C\uDF6B 2) Chocolate Cream");
            System.out.println("\uD83C\uDF53 3) Strawberry Jam");
            System.out.println("\uD83E\uDED0 4) Blueberry Jam");
            System.out.println("\uD83C\uDF4B 5) Lemon Curd");
            System.out.println("\uD83C\uDF6E 6) Custard");
            System.out.println("\uD83E\uDD0E 7) Mocha Cream");
            System.out.println("\uD83D\uDED1 0) Done adding regular fillings");
            System.out.println("=============================================");

            int choice = ValidUserInput.getIntChoice("\uD83C\uDFAF Select a filling (0 when done): ", 0, 7);

            if (choice == 0) {
                addingFillings = false;
            } else {
                String fillingName = getRegularFillingName(choice);
                boolean isExtra = ValidUserInput.getYesNo("  \uD83D\uDD0E Would you like EXTRA " + fillingName + "? (+$1.50)");
                Topping filling = new Topping(fillingName, ToppingCategory.REGULAR, isExtra);
                cake.addTopping(filling);
                // Show proper confirmation message
                if (isExtra) {
                    System.out.println("✅ Added " + fillingName + " (Extra) +$1.50");
                } else {
                    System.out.println("✅ Added " + fillingName + " - FREE");
                }
            }
        }
    }

    // ===== PREMIUM FILLINGS MENU =====
    public static void addPremiumFillings(Cake cake) {
        boolean addingFillings = true;

        while (addingFillings) {
            System.out.println("\n========== \uD83C\uDF70 PREMIUM FILLINGS (+$2.00 each) ==========");
            System.out.println("\uD83E\uDDC6 1) Pistachio Cream");
            System.out.println("\uD83E\uDDC2 2) Salted Caramel");
            System.out.println("\uD83E\uDDC0 3) Cream Cheese Filling");
            System.out.println("\uD83C\uDF47 4) Raspberry Compote");
            System.out.println("\uD83C\uDF30 5) Ferraro Rocher Filling");
            System.out.println("\uD83E\uDD6D 6) Mango Cream");
            System.out.println("\uD83D\uDED1 0) Done adding premium fillings");
            System.out.println("====================================================");

            int choice = ValidUserInput.getIntChoice("\uD83C\uDFAF Select a filling (0 when done): ", 0, 6);

            if (choice == 0) {
                addingFillings = false;
            } else {
                String fillingName = getPremiumFillingName(choice);
                boolean isExtra = ValidUserInput.getYesNo("  \uD83D\uDD0E Would you like EXTRA " + fillingName + "? (+$1.50 more)");
                Topping filling = new Topping(fillingName, ToppingCategory.PREMIUM, isExtra);
                cake.addTopping(filling);

                // Show proper confirmation with correct pricing
                System.out.printf("✅ Added %s - +$%.2f\n", isExtra ? fillingName + " (Premium + Extra)" : fillingName + " (Premium)", filling.getPrice());
            }
        }
    }

    // ===== REGULAR TOPPINGS MENU =====
    public static void addRegularToppings(Cake cake) {
        boolean addingToppings = true;

        while (addingToppings) {
            System.out.println("\n========== \uD83C\uDF70 REGULAR TOPPINGS (FREE) ==========");
            System.out.println("\uD83E\uDDC8 1) Buttercream");
            System.out.println("\uD83E\uDD63 2) Whipped Cream");
            System.out.println("\uD83C\uDF6B 3) Chocolate Ganache");
            System.out.println("\uD83C\uDF4A 4) Fresh Fruits");
            System.out.println("\uD83C\uDF52 5) Candied Fruits");
            System.out.println("✨6) Sprinkles");
            System.out.println("\uD83C\uDF30 7) Nuts");
            System.out.println("\uD83D\uDED1 0) Done adding regular toppings");
            System.out.println("============================================");

            int choice = ValidUserInput.getIntChoice("\uD83C\uDFAFSelect a topping (0 when done): ", 0, 7);

            if (choice == 0) {
                addingToppings = false;
            } else {
                String toppingName = getRegularToppingName(choice);
                boolean isExtra = ValidUserInput.getYesNo("  \uD83D\uDD0E Would you like EXTRA " + toppingName + "? (+$1.50)");
                Topping topping = new Topping(toppingName, ToppingCategory.REGULAR, isExtra);
                cake.addTopping(topping);
                // Show proper confirmation message
                if (isExtra) {
                    System.out.println("✅ Added " + toppingName + " (Extra) +$1.50");
                } else {
                    System.out.println("✅ Added " + toppingName + " - FREE");
                }
            }
        }
    }

    // ===== PREMIUM TOPPINGS MENU =====
    public static void addPremiumToppings(Cake cake) {
        boolean addingToppings = true;

        while (addingToppings) {
            System.out.println("\n========== \uD83C\uDF70 PREMIUM TOPPINGS (+$2.00 each) ==========");
            System.out.println("\uD83C\uDF1F 1) Edible Gold");
            System.out.println("☘ 2) Silver Leaves");
            System.out.println("\uD83C\uDF6B 3) Dubai Chocolate");
            System.out.println("\uD83C\uDF694) Macaron");
            System.out.println("\uD83C\uDF3A 5) Edible Flowers");
            System.out.println("\uD83E\uDD65 6) Coconut");
            System.out.println("\uD83D\uDED1 0) Done adding premium toppings");
            System.out.println("===================================================");

            int choice = ValidUserInput.getIntChoice("\uD83C\uDFAF Select a topping (0 when done): ", 0, 6);

            if (choice == 0) {
                addingToppings = false;
            } else {
                String toppingName = getPremiumToppingName(choice);
                boolean isExtra = ValidUserInput.getYesNo("  \uD83D\uDD0E Would you like EXTRA " + toppingName + "? (+$1.50 more)");
                Topping topping = new Topping(toppingName, ToppingCategory.PREMIUM, isExtra);
                cake.addTopping(topping);

                // Show proper confirmation with correct pricing
                System.out.printf("✅ Added %s - +$%.2f\n", isExtra ? toppingName + " (Premium + Extra)" : toppingName + " (Premium)", topping.getPrice());
            }
        }
    }

    // ===== HELPER METHODS TO GET FILLING/TOPPING NAMES =====
    private static String getRegularFillingName(int choice) {
        return switch (choice) {
            case 1 -> "Vanilla Cream";
            case 2 -> "Chocolate Cream";
            case 3 -> "Strawberry Jam";
            case 4 -> "Blueberry Jam";
            case 5 -> "Lemon Curd";
            case 6 -> "Custard";
            case 7 -> "Mocha Cream";
            default -> "Unknown Filling";
        };
    }

    private static String getPremiumFillingName(int choice) {
        return switch (choice) {
            case 1 -> "Pistachio Cream";
            case 2 -> "Salted Caramel";
            case 3 -> "Cream Cheese Filling";
            case 4 -> "Raspberry Compote";
            case 5 -> "Ferraro Rocher Filling";
            case 6 -> "Mango Cream";
            default -> "Unknown Filling";
        };
    }

    private static String getRegularToppingName(int choice) {
        return switch (choice) {
            case 1 -> "Buttercream";
            case 2 -> "Whipped Cream";
            case 3 -> "Chocolate Ganache";
            case 4 -> "Fresh Fruits";
            case 5 -> "Candied Fruits";
            case 6 -> "Sprinkles";
            case 7 -> "Nuts";
            default -> "Unknown Topping";
        };
    }

    private static String getPremiumToppingName(int choice) {
        return switch (choice) {
            case 1 -> "Edible Gold";
            case 2 -> "Silver Leaves";
            case 3 -> "Dubai Chocolate";
            case 4 -> "Macaron";
            case 5 -> "Edible Flowers";
            case 6 -> "Coconut";
            default -> "Unknown Topping";
        };
    }
}
