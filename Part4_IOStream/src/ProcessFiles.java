import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProcessFiles {

    public static void main(String[] args) {
        String productsFilePath = "Products.txt";
        String sellsFilePath = "Sells.txt";
        String totalsFilePath = "Totals.txt";

        try {
            Map<String, Product> products = readProducts(productsFilePath);
            Map<String, Integer> sells = readSells(sellsFilePath);
            Map<String, TotalsData> totals = calculateTotals(products, sells);
            writeTotals(totals, totalsFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Product> readProducts(String filePath) throws IOException {
        Map<String, Product> products = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length == 3) {
                    String name = parts[0];
                    String code = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    products.put(code, new Product(name, price));
                }
            }
        }
        return products;
    }

    private static Map<String, Integer> readSells(String filePath) throws IOException {
        Map<String, Integer> sells = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    String code = parts[0];
                    int quantity = Integer.parseInt(parts[1]);
                    sells.put(code, quantity);
                }
            }
        }
        return sells;
    }

    private static Map<String, TotalsData> calculateTotals(Map<String, Product> products, Map<String, Integer> sells) {
        Map<String, TotalsData> totals = new HashMap<>();
        for (Map.Entry<String, Integer> entry : sells.entrySet()) {
            String code = entry.getKey();
            int quantity = entry.getValue();
            if (products.containsKey(code)) {
                Product product = products.get(code);
                String name = product.getName();
                double price = product.getPrice();
                double total = quantity * price;

                totals.computeIfAbsent(name, k -> new TotalsData());
                TotalsData totalsData = totals.get(name);
                totalsData.addQuantity(quantity);
                totalsData.addTotal(total);
            }
        }
        return totals;
    }

    private static void writeTotals(Map<String, TotalsData> totals, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, TotalsData> entry : totals.entrySet()) {
                String name = entry.getKey();
                TotalsData totalsData = entry.getValue();
                int quantity = totalsData.getQuantity();
                double total = totalsData.getTotal();
                writer.write(String.format("%s %d %.2f%n", name, quantity, total));
            }
        }
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class TotalsData {
    private int quantity;
    private double total;

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void addTotal(double total) {
        this.total += total;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return total;
    }
}
