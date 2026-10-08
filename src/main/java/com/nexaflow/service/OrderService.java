package com.nexaflow.service;

import com.nexaflow.Order;
import com.nexaflow.Product;
import com.nexaflow.exception.InvalidProductException;
import com.nexaflow.exception.OrderNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private List<Order> orders = new ArrayList<>();

    // CREATE
    public void createOrder(Order order) {

        if (order == null) {
            throw new IllegalArgumentException(
                    "Order cannot be null."
            );
        }

        orders.add(order);

        System.out.println(
                "Order created successfully. Order ID: "
                        + order.getOrderId()
        );
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

        throw new OrderNotFoundException(
                "Order with ID " + orderId + " not found."
        );
    }

    // UPDATE - Update product quantity
    public void updateProductQuantity(
            int orderId,
            String productName,
            int newQuantity) {

        Order order = findOrderById(orderId);

        for (Product product : order.getProducts()) {

            if (product.getProductName()
                    .equalsIgnoreCase(productName)) {

                product.setQuantity(newQuantity);

                System.out.println(
                        "Product quantity updated successfully."
                );

                return;
            }
        }

        throw new InvalidProductException(
                "Product '" + productName +
                        "' not found in the order."
        );
    }

    // UPDATE - Add product
    public void addProductToOrder(
            int orderId,
            Product product) {

        if (product == null) {
            throw new InvalidProductException(
                    "Product cannot be null."
            );
        }

        Order order = findOrderById(orderId);

        order.getProducts().add(product);

        System.out.println(
                "Product added to order successfully."
        );
    }

    // DELETE - Remove product
    public void removeProductFromOrder(
            int orderId,
            String productName) {

        Order order = findOrderById(orderId);

        Product productToRemove = null;

        for (Product product : order.getProducts()) {

            if (product.getProductName()
                    .equalsIgnoreCase(productName)) {

                productToRemove = product;
                break;
            }
        }

        if (productToRemove == null) {

            throw new InvalidProductException(
                    "Product '" + productName +
                            "' not found in the order."
            );
        }

        order.getProducts().remove(productToRemove);

        System.out.println(
                "Product removed from order successfully."
        );
    }

    // DELETE - Delete complete order
    public void deleteOrder(int orderId) {

        Order order = findOrderById(orderId);

        orders.remove(order);

        System.out.println(
                "Order deleted successfully."
        );
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