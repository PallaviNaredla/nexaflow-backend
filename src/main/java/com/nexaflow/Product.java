package com.nexaflow;

import com.nexaflow.exception.InvalidProductException;

public class Product {

    private String productName;
    private double price;
    private int quantity;

    public Product(String productName, double price, int quantity) {

        if (productName == null || productName.trim().isEmpty()) {
            throw new InvalidProductException(
                    "Product name cannot be empty."
            );
        }

        if (price <= 0) {
            throw new InvalidProductException(
                    "Product price must be greater than 0."
            );
        }

        if (quantity <= 0) {
            throw new InvalidProductException(
                    "Product quantity must be greater than 0."
            );
        }

        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {

        if (quantity <= 0) {
            throw new InvalidProductException(
                    "Product quantity must be greater than 0."
            );
        }

        this.quantity = quantity;
    }

    public double calculateTotal() {
        return price * quantity;
    }

    public void displayProductDetails() {

        System.out.println(
                "Product: " + productName +
                        " | Price: " + price +
                        " | Quantity: " + quantity
        );
    }
}