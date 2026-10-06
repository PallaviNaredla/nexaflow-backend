package com.nexaflow;

import com.nexaflow.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // -------------------------------
        // CREATE USER
        // -------------------------------

        User user = new User(
                "Pallavi",
                "pallavi@gmail.com",
                21
        );

        // -------------------------------
        // CREATE PRODUCTS
        // -------------------------------

        Product laptop = new Product(
                "Laptop",
                75000,
                1
        );

        Product mouse = new Product(
                "Mouse",
                500,
                2
        );

        Product keyboard = new Product(
                "Keyboard",
                1500,
                1
        );

        // -------------------------------
        // CREATE PRODUCT LIST
        // -------------------------------

        List<Product> products = new ArrayList<>();

        products.add(laptop);
        products.add(mouse);

        // -------------------------------
        // CREATE ORDER
        // -------------------------------

        Order order = new Order(
                user,
                products
        );

        // -------------------------------
        // CREATE ORDER SERVICE
        // -------------------------------

        OrderService orderService = new OrderService();

        // -------------------------------
        // CREATE ORDER IN SERVICE
        // -------------------------------

        orderService.createOrder(order);

        // -------------------------------
        // DISPLAY INITIAL ORDER
        // -------------------------------

        System.out.println("\n===== INITIAL ORDER =====");

        orderService.displayAllOrders();

        // -------------------------------
        // UPDATE PRODUCT QUANTITY
        // -------------------------------

        System.out.println("\n===== UPDATE QUANTITY =====");

        orderService.updateProductQuantity(
                order.getOrderId(),
                "Mouse",
                5
        );

        orderService.displayAllOrders();

        // -------------------------------
        // ADD NEW PRODUCT
        // -------------------------------

        System.out.println("\n===== ADD PRODUCT =====");

        orderService.addProductToOrder(
                order.getOrderId(),
                keyboard
        );

        orderService.displayAllOrders();

        // -------------------------------
        // REMOVE PRODUCT
        // -------------------------------

        System.out.println("\n===== REMOVE PRODUCT =====");

        orderService.removeProductFromOrder(
                order.getOrderId(),
                "Mouse"
        );

        orderService.displayAllOrders();

        // -------------------------------
        // FIND ORDER
        // -------------------------------

        System.out.println("\n===== FIND ORDER =====");

        Order foundOrder = orderService.findOrderById(
                order.getOrderId()
        );

        if (foundOrder != null) {

            System.out.println(
                    "Order found with ID: "
                            + foundOrder.getOrderId()
            );

        } else {

            System.out.println("Order not found.");
        }

        // -------------------------------
        // TOTAL REVENUE
        // -------------------------------

        System.out.println("\n===== TOTAL REVENUE =====");

        System.out.println(
                "Total Revenue: "
                        + orderService.getTotalRevenue()
        );
    }
}