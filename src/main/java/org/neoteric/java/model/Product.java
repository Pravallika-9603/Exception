package org.neoteric.java.model;

public abstract class Product {

    private String productId;

    private String name;

    private double price;

    private int stock;

    public Product(String productId,String name,double price,int stock){

        this.productId=productId;

        this.name=name;

        this.price=price;

        this.stock=stock;

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
