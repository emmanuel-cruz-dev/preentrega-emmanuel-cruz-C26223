package com.techlab.product.model;

public abstract class Product {
    private static int counter = 0;

    private final int id;
    private String name;
    private double price;
    private Category category;

    public Product(String name, double price, Category category){
        this.id = ++counter;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public abstract String getType();

    public abstract String getDetails();

    @Override
    public String toString() {
        return String.format(
                "| %-4d | %-20s | $%-8.2f | %-12s | %-25s |",
                id,
                name,
                price,
                getType(),
                getDetails()
        );
    }
}
