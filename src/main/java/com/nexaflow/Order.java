package com.nexaflow;

import java.util.List;

public class Order {

    private static int counter = 1;
    private int orderId;
    private User user;
    private List<Product> products;

    public Order(User user, List<Product> products) {
        this.orderId = counter++;
        this.user = user;
        this.products = products;
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
}