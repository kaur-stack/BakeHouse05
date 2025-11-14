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

public class ReceiptsFileManager {
    private static final String RECEIPTS_FOLDER = "ReceiptData/";
    private static final DateTimeFormatter FILE_NAME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

    public void generateReceipt(Order order) {
        String fullFilePath = RECEIPTS_FOLDER + order.getOrderTime().format(FILE_NAME_FORMATTER) + ".txt";

        try (FileWriter fileWriter = new FileWriter(fullFilePath);
                  BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            writeReceiptHeader(bufferedWriter, order);

            writeOrderDetails(bufferedWriter, order);

            writeReceiptEnding(bufferedWriter, order);

            System.out.println("\n SUCCESS: Receipt saved to " + fullFilePath);

        } catch (IOException e) {
            System.err.println("\n✗ ERROR: Failed to save receipt: " + e.getMessage());
        }
    }

    private void writeReceiptHeader(BufferedWriter bufferedWriter, Order order) throws IOException {
        bufferedWriter.write("========================================================");
        bufferedWriter.newLine();
        bufferedWriter.write("              BAKEHOUSE05: Order Receipt                ");
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

    private void writeReceiptEnding(BufferedWriter bufferedWriter, Order order) throws IOException {
        bufferedWriter.write("--------------------------------------------------------");
        bufferedWriter.newLine();

        bufferedWriter.write(String.format("ORDER TOTAL: $%.2f", order.calculateTotal()));
        bufferedWriter.newLine();
        bufferedWriter.newLine();

        bufferedWriter.write("========================================================");
        bufferedWriter.newLine();
        bufferedWriter.write("         Thank you for visiting Bakehouse05!           ");
        bufferedWriter.newLine();
        bufferedWriter.write("              We hope you enjoy your treats!            ");
        bufferedWriter.newLine();
        bufferedWriter.write("========================================================");
        bufferedWriter.newLine();
    }
}
