package com.pluralsight.BakeHouse05.Interface;

public class Display {
    public static void displayWelcome() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("             WELCOME TO BAKEHOUSE 05!");
        System.out.println("             Your Custom Cake Shop");
        System.out.println("=".repeat(50) + "\n");
    }

    public static void displayHomeScreen() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                 HOME SCREEN");
        System.out.println("=".repeat(50));
        System.out.println();
        System.out.println("  1) New Order");
        System.out.println("  0) Exit");
        System.out.println();
        System.out.println("=".repeat(50));
    }

    public static void displayOrderScreen() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                 HOME SCREEN");
        System.out.println("=".repeat(50));
        System.out.println();
        System.out.println("1) Add Cake");
        System.out.println("2) Add Signature Cake");  // Signature
        System.out.println("3) Add Drink");
        System.out.println("4) Add Side");
        System.out.println("5) Checkout");
        System.out.println("❌0) Cancel Order");
        System.out.println();
        System.out.println("=".repeat(50));
    }

}
