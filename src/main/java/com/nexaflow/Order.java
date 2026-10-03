package com.nexaflow;

import java.util.List;

public class Order {

    // Auto-increment Order ID
    private static int counter = 1;
    private int orderId;

    private User user;
    private List<Product> products;

    // Constructor
    public Order(User user, List<Product> products) {
        this.user = user;
        this.products = products;
        this.orderId = counter++;
    }

    // Getter for Order ID
    public int getOrderId() {
        return orderId;
    }

    // Getter for User
    public User getUser() {
        return user;
    }

    // Getter for Products
    public List<Product> getProducts() {
        return products;
    }

    // Calculate total price of order
    public double calculateTotal() {
        double total = 0;

        for (Product product : products) {
            total += product.calculateTotal();
        }

        return total;
    }

    // Display Order Details
    public void displayOrderDetails() {
        System.out.println("\nOrder ID: " + orderId);
        System.out.println("User: " + user.getName());

        System.out.println("Products:");
        for (Product product : products) {
            System.out.println("- " + product.getProductName() +
                    " | Price: " + product.getPrice() +
                    " | Qty: " + product.getQuantity());
        }

        System.out.println("Total Order Price: " + calculateTotal());
    }
}