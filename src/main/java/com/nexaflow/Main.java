package com.nexaflow;

public class Main {
    public static void main(String[] args) {

        User user = new User("Pallavi", "pallavi@gmail.com", 21);
        user.displayDetails();

        Product product = new Product("Laptop", 75000, 2);
        product.displayProductDetails();
    }
}