package org.evavdb1.productionfactory;

public class ProductMainApp {
    public static void main(String[] args) {

        ProductSorter sorter01 = new ProductSorter();
        ProductFactory factory01 = new ProductFactory(sorter01);

        factory01.createProducts(100);
        System.out.println();
        ProductSorter.countProducts();

        System.out.println("\n***   The food products are   ***");
        sorter01.getFoodProducts()
                .forEach(System.out::println);

        System.out.println();
        System.out.println("***   The health products are   ***");
        sorter01.getHealthProducts()
                .forEach(System.out::println);

        System.out.println("\n***   The electric products are   ***");
        sorter01.getElectricProducts()
                .forEach(System.out::println);
    }
}
