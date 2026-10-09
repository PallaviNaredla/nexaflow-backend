package com.nexaflow;

import com.nexaflow.exception.InvalidProductException;
import com.nexaflow.exception.OrderNotFoundException;
import com.nexaflow.exception.ProductNotFoundException;
import com.nexaflow.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        User user = new User(
                "Pallavi",
                "pallavi@gmail.com",
                21
        );

        Product laptop = new Product("Laptop", 75000, 1);
        Product mouse = new Product("Mouse", 500, 2);
        Product keyboard = new Product("Keyboard", 1500, 1);

        List<Product> products = new ArrayList<>();
        products.add(laptop);
        products.add(mouse);

        Order order = new Order(user, products);

        OrderService orderService = new OrderService();

        // CREATE ORDER
        System.out.println("\n===== CREATE ORDER =====");
        orderService.createOrder(order);

        // DISPLAY ORDERS
        System.out.println("\n===== DISPLAY ORDERS =====");
        orderService.displayAllOrders();

        // UPDATE QUANTITY
        System.out.println("\n===== UPDATE QUANTITY =====");

        try {
            orderService.updateProductQuantity(
                    order.getOrderId(), "Mouse", 5
            );
        } catch (InvalidProductException
                 | OrderNotFoundException
                 | ProductNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // ADD PRODUCT
        System.out.println("\n===== ADD PRODUCT =====");

        try {
            orderService.addProductToOrder(
                    order.getOrderId(), keyboard
            );
        } catch (IllegalArgumentException
                 | OrderNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // REMOVE PRODUCT
        System.out.println("\n===== REMOVE PRODUCT =====");

        try {
            orderService.removeProductFromOrder(
                    order.getOrderId(), "Mouse"
            );
        } catch (InvalidProductException
                 | OrderNotFoundException
                 | ProductNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // TEST INVALID QUANTITY
        System.out.println("\n===== INVALID QUANTITY TEST =====");

        try {
            mouse.setQuantity(0);
        } catch (InvalidProductException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // TEST MISSING ORDER
        System.out.println("\n===== INVALID ORDER ID TEST =====");

        try {
            orderService.findOrderById(999);
        } catch (OrderNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // TEST MISSING PRODUCT
        System.out.println("\n===== MISSING PRODUCT TEST =====");

        try {
            orderService.removeProductFromOrder(
                    order.getOrderId(), "Mobile"
            );
        } catch (ProductNotFoundException
                 | OrderNotFoundException
                 | InvalidProductException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // DISPLAY FINAL ORDER
        System.out.println("\n===== FINAL ORDER =====");
        orderService.displayAllOrders();

        // REVENUE
        System.out.println("\n===== TOTAL REVENUE =====");
        System.out.println(
                "Total Revenue: " + orderService.getTotalRevenue()
        );

        System.out.println("\nProgram completed successfully.");
    }
}