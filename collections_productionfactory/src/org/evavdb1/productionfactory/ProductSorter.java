package org.evavdb1.productionfactory;
import java.util.ArrayList;
import java.util.List;

public class ProductSorter {

    private final List<Product> products = new ArrayList<>();
    private final List<FoodProduct> foodProducts = new ArrayList<>();
    private final List<HealthProduct> healthProducts = new ArrayList<>();
    private final List<ElectricProduct> electricProducts = new ArrayList<>();

    private static int count = 0;

    public List<FoodProduct> getFoodProducts() {        return foodProducts;    }
    public List<HealthProduct> getHealthProducts() {        return healthProducts;    }
    public List<ElectricProduct> getElectricProducts() {        return electricProducts;    }


    public static void countProducts() {
        System.out.println(count + " products are sorted.");
    }

    public void sortProduct(Product product) {
        for (Product item : products) {
            if (item.getProdID() == product.getProdID()) return;
        }

        if (product instanceof FoodProduct) {
            foodProducts.add((FoodProduct)product);
        } else if (product instanceof HealthProduct) {
            healthProducts.add((HealthProduct)product);
        } else if (product instanceof ElectricProduct) {
            electricProducts.add((ElectricProduct)product);
        }
        products.add(product);
        count++;
    }
}
