package com.nexaflow;

import com.nexaflow.service.OrderService;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Users
        User user1 = new User("Pallavi", "pallavi@gmail.com", 21);
        User user2 = new User("Ravi", "ravi@gmail.com", 25);

        // Products
        Product p1 = new Product("Laptop", 75000, 1);
        Product p2 = new Product("Mouse", 500, 2);
        Product p3 = new Product("Keyboard", 1500, 1);

        // Orders
        List<Product> list1 = Arrays.asList(p1, p2);
        List<Product> list2 = Arrays.asList(p3);

        Order order1 = new Order(user1, list1);
        Order order2 = new Order(user2, list2);

        // Service
        OrderService service = new OrderService();

        service.createOrder(order1);
        service.createOrder(order2);

        service.displayAllOrders();

        service.findOrderById(1);
    }
}