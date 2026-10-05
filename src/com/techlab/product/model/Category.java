package com.techlab.product.model;

public class Category {
    private static int counter = 0;

    private final int id;
    private String name;
    private String description;

    public Category(String name, String description) {
        this.id = ++counter;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
