package com.nexaflow.service;

import com.nexaflow.Order;
import com.nexaflow.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private List<Order> orders = new ArrayList<>();

    // CREATE
    public void createOrder(Order order) {
        orders.add(order);
        System.out.println("Order created successfully. Order ID: " + order.getOrderId());
    }

    // READ - Display all orders
    public void displayAllOrders() {

        if (orders.isEmpty()) {
            System.out.println("No orders available.");
            return;
        }

        for (Order order : orders) {
            order.displayOrderDetails();
        }
    }

    // READ - Find order by ID
    public Order findOrderById(int orderId) {

        for (Order order : orders) {

            if (order.getOrderId() == orderId) {
                return order;
            }
        }

        return null;
    }

    // UPDATE - Update product quantity
    public void updateProductQuantity(int orderId, String productName, int newQuantity) {

        Order order = findOrderById(orderId);

        if (order == null) {
            System.out.println("Order not found.");
            return;
        }

        for (Product product : order.getProducts()) {

            if (product.getProductName().equalsIgnoreCase(productName)) {

                product.setQuantity(newQuantity);

                if (product.getQuantity() == newQuantity) {
                    System.out.println(
                            "Product quantity updated successfully."
                    );
                }

                return;
            }
        }

        System.out.println("Product not found in the order.");
    }

    // UPDATE - Add product to existing order
    public void addProductToOrder(int orderId, Product product) {

        Order order = findOrderById(orderId);

        if (order == null) {
            System.out.println("Order not found.");
            return;
        }

        order.getProducts().add(product);

        System.out.println(
                "Product added to order successfully."
        );
    }

    // DELETE - Remove product from existing order
    public void removeProductFromOrder(int orderId, String productName) {

        Order order = findOrderById(orderId);

        if (order == null) {
            System.out.println("Order not found.");
            return;
        }

        Product productToRemove = null;

        for (Product product : order.getProducts()) {

            if (product.getProductName().equalsIgnoreCase(productName)) {
                productToRemove = product;
                break;
            }
        }

        if (productToRemove != null) {

            order.getProducts().remove(productToRemove);

            System.out.println(
                    "Product removed from order successfully."
            );

        } else {

            System.out.println(
                    "Product not found in the order."
            );
        }
    }

    // DELETE - Delete complete order
    public void deleteOrder(int orderId) {

        Order order = findOrderById(orderId);

        if (order != null) {

            orders.remove(order);

            System.out.println(
                    "Order deleted successfully."
            );

        } else {

            System.out.println(
                    "Order not found."
            );
        }
    }

    // Calculate total revenue
    public double getTotalRevenue() {

        double totalRevenue = 0;

        for (Order order : orders) {
            totalRevenue += order.calculateTotal();
        }

        return totalRevenue;
    }
}