package com.pluralsight.BakeHouse05.ControlRoom;

import java.util.Scanner;

public class ValidUserInput {
    private static final Scanner console = new Scanner(System.in);

    public static int getIntChoice(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int choice = Integer.parseInt(console.nextLine().trim());
                if (choice >= min && choice <= max) {
                    return choice;
                }
                System.out.println("Please enter a number between " + min + " and " + max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public static boolean getYesNo(String prompt) {
        while (true) {
            System.out.print(prompt + " (y/n): ");
            String input = console.nextLine().trim().toLowerCase();
            if (input.equals("y") || input.equals("yes")) {
                return true;
            } else if (input.equals("n") || input.equals("no")) {
                return false;
            }
            System.out.println("Please enter 'y' or 'n'");
        }
    }

    public static void waitForEnter() {
        System.out.print("\nPress Enter to continue...");
        console.nextLine();
    }
}
