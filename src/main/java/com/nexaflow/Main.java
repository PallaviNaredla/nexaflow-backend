package com.nexaflow;
import com.nexaflow.Order;
import com.nexaflow.Product;
import com.nexaflow.User;
import com.nexaflow.service.OrderService;

public class Main {
    public static void main(String[] args) {

        User user = new User("Pallavi", "pallavi@gmail.com", 21);

        Product p1 = new Product("Laptop", 75000, 1);
        Product p2 = new Product("Phone", 20000, 2);

        Product[] products = {p1, p2};

        Order order = new Order(user, products);

        // 🔹 Service layer
        OrderService orderService = new OrderService();

        orderService.createOrder(order);
        orderService.displayOrder(order);
    }
}