package com.techlab.product.model;

public class ProductFood extends Product {

    private double weightKg;

    public ProductFood(String name, double price, Category category, double weightKg){
        super(name, price, category);
        this.weightKg = weightKg;
    }

    @Override
    public String getType() {
        return "Alimentos";
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    @Override
    public String getDetails() {
        return "Peso:" + weightKg + "kg";
    }
}
