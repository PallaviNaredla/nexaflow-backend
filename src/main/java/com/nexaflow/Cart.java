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
}