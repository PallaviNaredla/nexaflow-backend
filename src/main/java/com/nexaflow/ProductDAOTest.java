
package com.nexaflow;

import com.nexaflow.dao.ProductDAO;

import java.sql.SQLException;

public class ProductDAOTest {

    public static void main(String[] args) {

        ProductDAO productDAO = new ProductDAO();

        // Change this to an ID that exists in your database.
        int productId = 101;

        try {
            System.out.println("Searching for product ID: "
                    + productId);

            Product product =
                    productDAO.getProductById(productId);

            if (product != null) {
                System.out.println("Product found!");
                product.displayProduct();
            } else {
                System.out.println("Product not found.");
            }

        } catch (SQLException e) {
            System.out.println("Database operation failed.");
            e.printStackTrace();

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: "
                    + e.getMessage());
        }
    }
}
