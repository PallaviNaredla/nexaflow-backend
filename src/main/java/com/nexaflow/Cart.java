package com.nexaflow;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private User user;
    private List<Product> products;

    // Constructor
    public Cart(User user) {
        this.user = user;
        this.products = new ArrayList<>(); // start with empty cart
    }

    // Getter for user
    public User getUser() {
        return user;
    }

    // Getter for products
    public List<Product> getProducts() {
        return products;
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public void removeProduct(Product product) {
        products.remove(product);
    }
    public double calculateCartTotal() {
        double total = 0;

        for (Product product : products) {
            total += product.calculateTotal();
        }

        return total;
    }
    public void displayCart() {
        System.out.println("\nCart for: " + user.getName());

        for (Product product : products) {
            System.out.println("- " + product.getProductName() +
                    " | Price: " + product.getPrice() +
                    " | Qty: " + product.getQuantity());
        }

        System.out.println("Total Cart Value: " + calculateCartTotal());
    }
}