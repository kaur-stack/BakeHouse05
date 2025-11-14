package com.pluralsight.BakeHouse05.Order;

import com.pluralsight.BakeHouse05.BaseRoom.Product;
import com.pluralsight.BakeHouse05.Products.Cake;
import com.pluralsight.BakeHouse05.Products.Drink;
import com.pluralsight.BakeHouse05.Products.Side;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * ReceiptsFileManager: save order receipts to text files.
 */
public class ReceiptsFileManager {
    private static final String RECEIPTS_FOLDER = "ReceiptData/";
    private static final DateTimeFormatter FILE_NAME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

    /**
     * Create and write a receipt file for the given order.
     *
     * @param order the order to save
     */
    public void generateReceipt(Order order) {
        String fullFilePath = RECEIPTS_FOLDER + order.getOrderTime().format(FILE_NAME_FORMATTER) + ".txt";

        try (FileWriter fileWriter = new FileWriter(fullFilePath);
                  BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            writeReceiptHeader(bufferedWriter, order);

            writeOrderDetails(bufferedWriter, order);

            writeReceiptEnding(bufferedWriter, order);

            System.out.println("\n✅ SUCCESS: Receipt saved to " + fullFilePath);

        } catch (IOException e) {
            System.err.println("\n❌ ERROR: Failed to save receipt: " + e.getMessage());
        }
    }

    /**
     * Write the top header of the receipt file.
     * @param bufferedWriter writer to the file
     * @param order the order
     * @throws IOException if writing fails
     */
    private void writeReceiptHeader(BufferedWriter bufferedWriter, Order order) throws IOException {
        bufferedWriter.write("========================================================");
        bufferedWriter.newLine();
        bufferedWriter.write("             \uD83C\uDF70BAKEHOUSE05: Order Receipt\uD83C\uDF70                ");
        bufferedWriter.newLine();
        bufferedWriter.write("           Your Custom Cake Shop Experience            ");
        bufferedWriter.newLine();
        bufferedWriter.write("========================================================");
        bufferedWriter.newLine();
        bufferedWriter.write("Order Time: " + order.getOrderTime().format(FILE_NAME_FORMATTER));
        bufferedWriter.newLine();
        bufferedWriter.write("--------------------------------------------------------");
        bufferedWriter.newLine();
        bufferedWriter.newLine();
    }

    /**
     * Write the order items section (cakes, drinks, sides).
     * @param bufferedWriter writer to the file
     * @param order the order
     * @throws IOException if writing fails
     */
    private void writeOrderDetails(BufferedWriter bufferedWriter, Order order) throws IOException {
        List<Product> allProducts = order.getProducts();

        List<Cake> cakes = new ArrayList<>();
        List<Drink> drinks = new ArrayList<>();
        List<Side> sides = new ArrayList<>();

        for (Product product : allProducts) {
            if (product instanceof Cake) {
                cakes.add((Cake) product);
            } else if (product instanceof Drink) {
                drinks.add((Drink) product);
            } else if (product instanceof Side) {
                sides.add((Side) product);
            }
        }

        if (!cakes.isEmpty()) {
            bufferedWriter.write("CAKES:");
            bufferedWriter.newLine();
            for (int i = 0; i < cakes.size(); i++) {
                bufferedWriter.write((i + 1) + ". ");
                bufferedWriter.write(cakes.get(i).getDescription());
                bufferedWriter.newLine();
            }
            bufferedWriter.newLine();
        }

        if (!drinks.isEmpty()) {
            bufferedWriter.write("DRINKS:");
            bufferedWriter.newLine();
            for (int i = 0; i < drinks.size(); i++) {
                bufferedWriter.write((i + 1) + ". ");
                bufferedWriter.write(drinks.get(i).getDescription());
                bufferedWriter.newLine();
            }
            bufferedWriter.newLine();
        }

        if (!sides.isEmpty()) {
            bufferedWriter.write("SIDES:");
            bufferedWriter.newLine();
            for (int i = 0; i < sides.size(); i++) {
                bufferedWriter.write((i + 1) + ". ");
                bufferedWriter.write(sides.get(i).getDescription());
                bufferedWriter.newLine();
            }
            bufferedWriter.newLine();
        }

    }

    /**
     * Write footer with total and thank you text.
     * @param bufferedWriter writer to the file
     * @param order the order
     * @throws IOException if writing fails
     */
    private void writeReceiptEnding(BufferedWriter bufferedWriter, Order order) throws IOException {
        bufferedWriter.write("--------------------------------------------------------");
        bufferedWriter.newLine();

        bufferedWriter.write(String.format("ORDER TOTAL: $%.2f", order.calculateTotal()));
        bufferedWriter.newLine();
        bufferedWriter.newLine();

        bufferedWriter.write("========================================================");
        bufferedWriter.newLine();
        bufferedWriter.write("       ❤\uFE0FThank you for visiting Bakehouse05!❤\uFE0F           ");
        bufferedWriter.newLine();
        bufferedWriter.write("             We hope you enjoy your treats!🍰            ");
        bufferedWriter.newLine();
        bufferedWriter.write("========================================================");
        bufferedWriter.newLine();
    }
}
