package com.nexaflow;

import com.nexaflow.exception.InvalidProductException;

import java.util.List;

public class Order {

    private static int counter = 1;

    private int orderId;
    private User user;
    private List<Product> products;

    public Order(User user, List<Product> products) {

        if (user == null) {
            throw new IllegalArgumentException(
                    "User cannot be null."
            );
        }

        if (products == null || products.isEmpty()) {
            throw new IllegalArgumentException(
                    "Order must contain at least one product."
            );
        }

        for (Product product : products) {

            if (product == null) {
                throw new InvalidProductException(
                        "Order cannot contain a null product."
                );
            }
        }

        this.user = user;
        this.products = products;
        this.orderId = counter++;
    }

    public int getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotal() {

        double total = 0;

        for (Product product : products) {
            total += product.calculateTotal();
        }

        return total;
    }

    public void displayOrderDetails() {

        System.out.println("\nOrder ID: " + orderId);
        System.out.println("User: " + user.getName());
        System.out.println("Products:");

        for (Product product : products) {

            System.out.println(
                    "- " + product.getProductName() +
                            " | Price: " + product.getPrice() +
                            " | Qty: " + product.getQuantity()
            );
        }

        System.out.println(
                "Total Order Price: " + calculateTotal()
        );
    }
}