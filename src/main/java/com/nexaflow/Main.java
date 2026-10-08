package com.nexaflow;

import com.nexaflow.exception.InvalidProductException;
import com.nexaflow.exception.OrderNotFoundException;
import com.nexaflow.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // --------------------------------
        // CREATE USER
        // --------------------------------

        User user = new User(
                "Pallavi",
                "pallavi@gmail.com",
                21
        );

        // --------------------------------
        // CREATE PRODUCTS
        // --------------------------------

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

        // --------------------------------
        // CREATE PRODUCT LIST
        // --------------------------------

        List<Product> products = new ArrayList<>();

        products.add(laptop);
        products.add(mouse);

        // --------------------------------
        // CREATE ORDER
        // --------------------------------

        Order order = new Order(
                user,
                products
        );

        // --------------------------------
        // CREATE ORDER SERVICE
        // --------------------------------

        OrderService orderService = new OrderService();

        // --------------------------------
        // CREATE ORDER
        // --------------------------------

        orderService.createOrder(order);

        // --------------------------------
        // DISPLAY INITIAL ORDER
        // --------------------------------

        System.out.println("\n===== INITIAL ORDER =====");

        orderService.displayAllOrders();

        // --------------------------------
        // UPDATE QUANTITY
        // --------------------------------

        System.out.println("\n===== UPDATE QUANTITY =====");

        orderService.updateProductQuantity(
                order.getOrderId(),
                "Mouse",
                5
        );

        orderService.displayAllOrders();

        // --------------------------------
        // ADD PRODUCT
        // --------------------------------

        System.out.println("\n===== ADD PRODUCT =====");

        orderService.addProductToOrder(
                order.getOrderId(),
                keyboard
        );

        orderService.displayAllOrders();

        // --------------------------------
        // REMOVE PRODUCT
        // --------------------------------

        System.out.println("\n===== REMOVE PRODUCT =====");

        orderService.removeProductFromOrder(
                order.getOrderId(),
                "Mouse"
        );

        orderService.displayAllOrders();

        // --------------------------------
        // INVALID QUANTITY TEST
        // --------------------------------

        System.out.println("\n===== INVALID QUANTITY TEST =====");

        try {

            Product invalidProduct = new Product(
                    "Headphones",
                    2000,
                    0
            );

        } catch (InvalidProductException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        // --------------------------------
        // INVALID PRICE TEST
        // --------------------------------

        System.out.println("\n===== INVALID PRICE TEST =====");

        try {

            Product invalidProduct = new Product(
                    "Tablet",
                    -5000,
                    1
            );

        } catch (InvalidProductException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        // --------------------------------
        // EMPTY PRODUCT NAME TEST
        // --------------------------------

        System.out.println("\n===== EMPTY PRODUCT NAME TEST =====");

        try {

            Product invalidProduct = new Product(
                    "",
                    1000,
                    1
            );

        } catch (InvalidProductException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        // --------------------------------
        // INVALID ORDER ID TEST
        // --------------------------------

        System.out.println("\n===== INVALID ORDER ID TEST =====");

        try {

            orderService.findOrderById(999);

        } catch (OrderNotFoundException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        // --------------------------------
        // INVALID PRODUCT UPDATE TEST
        // --------------------------------

        System.out.println("\n===== INVALID PRODUCT TEST =====");

        try {

            orderService.updateProductQuantity(
                    order.getOrderId(),
                    "Mobile",
                    2
            );

        } catch (InvalidProductException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        // --------------------------------
        // TOTAL REVENUE
        // --------------------------------

        System.out.println("\n===== TOTAL REVENUE =====");

        System.out.println(
                "Total Revenue: "
                        + orderService.getTotalRevenue()
        );
    }
}