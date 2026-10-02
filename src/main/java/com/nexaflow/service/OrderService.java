package com.nexaflow.service;

import com.nexaflow.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private List<Order> orders = new ArrayList<>();

    // Create Order
    public void createOrder(Order order) {
        orders.add(order);
        System.out.println("Order Created with ID: " + order.getOrderId());
    }

    // Display All Orders
    public void displayAllOrders() {
        for (Order order : orders) {
            System.out.println("\nOrder ID: " + order.getOrderId());
            System.out.println("User: " + order.getUser().getName());

            System.out.println("Products:");
            order.getProducts().forEach(p ->
                    System.out.println("- " + p.getProductName() +
                            " | Price: " + p.getPrice() +
                            " | Qty: " + p.getQuantity())
            );

            System.out.println("Total: " + order.calculateTotal());
        }
    }

    // Find Order by ID
    public void findOrderById(int id) {
        for (Order order : orders) {
            if (order.getOrderId() == id) {
                System.out.println("Order Found: ID " + id);
                System.out.println("Total: " + order.calculateTotal());
                return;
            }
        }
        System.out.println("Order not found!");
    }
}