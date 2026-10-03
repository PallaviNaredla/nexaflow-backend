package com.nexaflow.service;

import com.nexaflow.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private List<Order> orders = new ArrayList<>();

    // Create Order
    public void createOrder(Order order) {
        orders.add(order);
    }

    // Display all orders
    public void displayAllOrders() {
        for (Order order : orders) {
            order.displayOrderDetails();
        }
    }

    // Find order by ID
    public Order findOrderById(int id) {
        for (Order order : orders) {
            if (order.getOrderId() == id) {
                System.out.println("Order Found:");
                order.displayOrderDetails();
                return order;
            }
        }
        System.out.println("Order not found");
        return null;
    }

    // ✅ DELETE ORDER (you were missing this)
    public void deleteOrder(int id) {
        Order found = null;

        for (Order order : orders) {
            if (order.getOrderId() == id) {
                found = order;
                break;
            }
        }

        if (found != null) {
            orders.remove(found);
            System.out.println("Order deleted successfully");
        } else {
            System.out.println("Order not found");
        }
    }

    // ✅ TOTAL REVENUE (you were missing this)
    public double getTotalRevenue() {
        double total = 0;

        for (Order order : orders) {
            total += order.calculateTotal();
        }

        return total;
    }
}