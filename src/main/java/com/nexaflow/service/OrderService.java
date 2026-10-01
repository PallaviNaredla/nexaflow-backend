package com.nexaflow.service;

import com.nexaflow.Order;

public class OrderService {

    // 🔹 Create Order
    public Order createOrder(Order order) {
        return order;
    }

    // 🔹 Calculate total using Order object
    public double calculateTotal(Order order) {
        return order.calculateTotal();
    }

    // 🔹 Display order details
    public void displayOrder(Order order) {
        order.displayOrderDetails();
    }
}
