package com.nexaflow;

import com.nexaflow.service.OrderService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 🔹 Create Users
        User user1 = new User("Pallavi", "pallavi@gmail.com", 21);
        User user2 = new User("Ravi", "ravi@gmail.com", 25);

        // 🔹 Create Products
        Product p1 = new Product("Laptop", 75000, 1);
        Product p2 = new Product("Mouse", 500, 2);
        Product p3 = new Product("Keyboard", 1500, 1);

        // 🔹 Day 8 — Cart Testing
        Cart cart1 = new Cart(user1);

        System.out.println("Cart created for: " + cart1.getUser().getName());
        System.out.println("Initial cart size: " + cart1.getProducts().size());

        // 🔹 Add products manually (temporary for testing)
        cart1.getProducts().add(p1);
        cart1.getProducts().add(p2);

        System.out.println("Cart size after adding products: " + cart1.getProducts().size());

        // 🔹 Convert Cart → Order (simulation)
        List<Product> orderProducts = new ArrayList<>(cart1.getProducts());

        Order order1 = new Order(user1, orderProducts);

        // 🔹 Another Order
        List<Product> list2 = Arrays.asList(p3);
        Order order2 = new Order(user2, list2);

        // 🔹 Order Service
        OrderService service = new OrderService();

        service.createOrder(order1);
        service.createOrder(order2);

        // 🔹 Display all orders
        service.displayAllOrders();

        // 🔹 Find order
        service.findOrderById(1);

        // 🔹 Delete order
        service.deleteOrder(2);

        // 🔹 Display after delete
        service.displayAllOrders();

        // 🔹 Revenue
        System.out.println("Total Revenue: " + service.getTotalRevenue());
    }
}