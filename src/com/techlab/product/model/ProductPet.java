package com.techlab.product.model;

public class ProductPet extends Product{

    private String flavor;

    public ProductPet(String name, double price, Category category, String flavor) {
        super(name, price, category);
        this.flavor = flavor;
    }

    @Override
    public String getType() {
        return "Mascotas";
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public String getDetails(){
        return "Sabor:" + flavor;
    }
}
