package com.pluralsight.BakeHouse05.Interface;

public class Display {
    // ANSI color codes
    private static final String RESET = "\u001B[0m";
    private static final String YELLOW = "\u001B[33m";

    public static void displayWelcome() {
        System.out.println("\n");
        BillBoard.displayBillboard();
        System.out.println("\n");
        System.out.println("\n" + YELLOW + "=".repeat(50));
        System.out.println("   \uD83C\uDF53\uD83C\uDF70\uD83D\uDC8C\uD83E\uDDF8 WELCOME TO BAKEHOUSE 05! \uD83C\uDF53\uD83C\uDF70\uD83D\uDC8C\uD83E\uDDF8");
        System.out.println("             Your Custom Cake Shop");
        System.out.println("=".repeat(50) + "\n");
    }

    public static void displayHomeScreen() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                 \uD83C\uDFE0 HOME SCREEN");
        System.out.println("=".repeat(50));
        System.out.println();
        System.out.println(" \uD83D\uDED2 1) New Order");
        System.out.println(" \uD83D\uDD1A 0) Exit");
        System.out.println();
        System.out.println("=".repeat(50));
    }

    public static void displayOrderScreen() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                \uD83C\uDF82 Order SCREEN");
        System.out.println("=".repeat(50));
        System.out.println();
        System.out.println("\uD83C\uDF82 1) Add Cake");
        System.out.println("\uD83C\uDF80 2) Add Signature Cake");  // Signature
        System.out.println("☕ 3) Add Drink");
        System.out.println("\uD83C\uDF6A 4) Add Side");
        System.out.println("\uD83D\uDED2 5) Checkout");
        System.out.println("❌0) Cancel Order");
        System.out.println();
        System.out.println("=".repeat(50));
    }
}
