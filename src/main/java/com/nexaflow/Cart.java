package com.nexaflow;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private User user;
    private List<Product> products;

    // Constructor
    public Cart(User user) {
        this.user = user;
        this.products = new ArrayList<>();
    }

    // Getters
    public User getUser() {
        return user;
    }

    public List<Product> getProducts() {
        return products;
    }

    // Add product
    public void addProduct(Product product) {
        products.add(product);
    }

    // Remove product
    public void removeProduct(Product product) {
        products.remove(product);
    }

    // Calculate total
    public double calculateCartTotal() {
        double total = 0;

        for (Product product : products) {
            total += product.calculateTotal();
        }

        return total;
    }

    // Display cart
    public void displayCart() {
        System.out.println("\nCart for: " + user.getName());

        if (products.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        for (Product product : products) {
            System.out.println("- " + product.getProductName() +
                    " | Price: " + product.getPrice() +
                    " | Qty: " + product.getQuantity());
        }

        System.out.println("Total Cart Value: " + calculateCartTotal());
    }

    // ✅ Checkout (CORE FEATURE)
    public Order checkout() {

        if (products.isEmpty()) {
            System.out.println("Cart is empty. Cannot checkout.");
            return null;
        }

        // Convert Cart → Order
        Order order = new Order(user, new ArrayList<>(products));

        // Clear cart
        products.clear();

        System.out.println("\nCheckout successful. Order created.");

        return order;
    }
}