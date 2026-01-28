package org.evavdb1.productionfactory;

public class Product {

    private String name;
    private int prodID;

    public Product(String name, int prodID) {
        this.name = name;
        this.prodID = prodID;
    }

    public int getProdID() {        return prodID;    }
    public String getName() {        return name;    }

    @Override
    public String toString() {
        return prodID + " - " +name;
    }
}
