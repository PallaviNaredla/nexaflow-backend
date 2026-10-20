
package com.nexaflow;

public class Product {

    private int productId;
    private String productName;
    private double price;
    private int quantity;

    // Constructor used by existing code
    public Product(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Constructor used when retrieving a product from the database
    public Product(int productId, String productName,
                   double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
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

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(
                    "Price must be greater than zero."
            );
        }
        this.price = price;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException(
                    "Quantity cannot be negative."
            );
        }
        this.quantity = quantity;
    }

    public double calculateTotal() {
        return price * quantity;
    }

    public void displayProduct() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Available Quantity: " + quantity);
    }
}
