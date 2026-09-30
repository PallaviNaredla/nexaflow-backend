package com.nexaflow;

public class Order {

    private User user;
    private Product[] products;
    public Order(User user, Product[] products) {
        this.user = user;
        this.products = products;
    }
    //total price
    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.calculateTotal();
        }
        return total;
    }
    //order details
    public void displayOrderDetails() {
        System.out.println("\nOrder Details:");
        System.out.println("User: " + user.getName());
        System.out.println("\nProducts:");
        for (Product product : products) {
            System.out.println("- " + product.getProductName() +
                    " | Price: " + product.getPrice() +
                    " | Qty: " + product.getQuantity());
        }
        System.out.println("\nTotal Order Price: " + calculateTotal());
    }
}