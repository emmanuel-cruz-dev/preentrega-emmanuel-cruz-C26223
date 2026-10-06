package com.techlab.product.model;

public class ProductSport extends Product {

    private String sport;

    public ProductSport(String name, double price, Category category, String sport) {
        super(name, price, category);
        this.sport = sport;
    }

    @Override
    public String getType() {
        return "Deportes";
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    @Override
    public String getDetails() {
        return "Deporte: " + sport;
    }
}
