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

        // Cart Flow
        Cart cart = new Cart(user1);

        cart.addProduct(p1);
        cart.addProduct(p2);

        cart.displayCart();

        // ✅ Checkout
        Order order1 = cart.checkout();

        // Add to service
        OrderService service = new OrderService();

        if (order1 != null) {
            service.createOrder(order1);
        }

        // Check cart after checkout
        System.out.println("\nCart after checkout:");
        cart.displayCart();

        // Second Order (for testing multiple orders)
        List<Product> list2 = Arrays.asList(p3);
        Order order2 = new Order(user2, list2);
        service.createOrder(order2);

        // Display Orders
        service.displayAllOrders();

        // Find Order
        service.findOrderById(1);

        // Delete Order
        service.deleteOrder(2);

        // Display again
        service.displayAllOrders();

        // Revenue
        System.out.println("\nTotal Revenue: " + service.getTotalRevenue());
    }
}