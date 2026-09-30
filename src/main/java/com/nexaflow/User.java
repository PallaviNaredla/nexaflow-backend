 package com.nexaflow;

    public class User {
        String name;
        String email;
        int age;

        public User(String name, String email, int age) {
            this.name = name;
            this.email = email;
            this.age = age;
        }
        public String getName(){
            return name;
        }
        public void displayDetails() {
            System.out.println("User Details:");
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Age: " + age);
        }
    }
