package com.esipe.ms.model;

public class Product {

    private int productId;
    private String label;
    private float unitPrice;

    public Product(int productId, String label, float unitPrice) {
        this.productId = productId;
        this.label = label;
        this.unitPrice = unitPrice;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }



    @Override
    public String toString() {
        return "Product{"+
                "id=" + productId +
                ", unitPrice='"+ unitPrice + '\'' +
                '}';
    }
}
