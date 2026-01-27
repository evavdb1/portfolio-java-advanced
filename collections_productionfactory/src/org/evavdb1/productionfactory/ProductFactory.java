package org.evavdb1.productionfactory;
import java.util.Random;

public class ProductFactory {

    private final ProductSorter productSorter;

    private final String[] foodProducts = {"Apple", "Steak", "Potatoes", "Salad", "Pear"};
    private final String[] healthProducts = {"Face cream", "Vitamins", "Eye drops", "Toothpaste", "Shampoo"};
    private final String[] electricProducts = {"Hair dryer", "Vacuum", "Mixer", "Washing machine", "Dishwasher"};

    Random random = new Random();

    public ProductFactory(ProductSorter productSorter) {
        this.productSorter = productSorter;
    }

    public void createProducts (int amount) {
        for (int i = 0; i < amount; i++) {
            int type = random.nextInt(3);
            int id = random.nextInt(150);

            Product product;

            switch (type) {
                case 0 -> {
                    int foodCat = random.nextInt(foodProducts.length);
                    String foodName = foodProducts[foodCat];
                    product = new FoodProduct(foodName, id);
                }
                case 1 -> {
                    int healthCat = random.nextInt(healthProducts.length);
                    String healthName = healthProducts[healthCat];
                    product = new HealthProduct(healthName, id);
                }
                case 2 -> {
                    int electricCat = random.nextInt(electricProducts.length);
                    String electricName = electricProducts[electricCat];
                    product = new ElectricProduct(electricName, id);
                }
                default -> throw new IllegalStateException("Unexpected value: " + type);
            }
            productSorter.sortProduct(product);
        }
    }
}
