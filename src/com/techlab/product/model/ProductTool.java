package com.techlab.product.model;

public class ProductTool extends Product{

    private int warrantyMonths;

    public ProductTool(String name, double price, Category category, int warrantyMonths){
        super(name, price, category);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String getType() {
        return "Herramientas";
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String getDetails() {
        return "Garantía: " + warrantyMonths + " meses";
    }
}
