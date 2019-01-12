package application;

import entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the csv file directory: ");
        String filePath = sc.nextLine();

        List<Product> productsList = new ArrayList<>();

        File sourceFile = new File(filePath);
        boolean status = new File(sourceFile.getPath() + "\\result").mkdir();

        String targetFile = sourceFile.getParent() + "\\result\\summary.csv";

        try (BufferedReader br = new BufferedReader( new FileReader(filePath) )) {

            String line = br.readLine();
            while (line != null) {

                String[] items = line.split(",");
                String productName = items[0];
                Double productPrice = Double.parseDouble(items[1]);
                Integer productQuantity = Integer.parseInt(items[2]);

                Product product = new Product(productName, productPrice, productQuantity);
                productsList.add(product);

                line = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter( new FileWriter(targetFile) )) {

                for (Product product : productsList) {

                    bw.write(product.getName() + ", " + String.format("%.2f", product.total()));
                    bw.newLine();

                }

                System.out.print("File created!");

            } catch (IOException e) {

                e.printStackTrace();

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        sc.close();

    }

}
