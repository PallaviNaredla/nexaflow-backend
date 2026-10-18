
package com.nexaflow;

import com.nexaflow.dao.ProductDAO;
import java.sql.SQLException;

public class ProductDAOTest {

    public static void main(String[] args) {

        ProductDAO productDAO = new ProductDAO();

        try {
            System.out.println("Before update:");
            productDAO.getAllProducts();

            System.out.print("Enter Oracle password: ");
            java.util.Scanner scanner =
                    new java.util.Scanner(System.in);
            String password = scanner.nextLine();

            // Update product 104: Headphones
            boolean updated = productDAO.updateProduct(
                    104, 2800.00, 25
            );

            if (updated) {
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("Product ID not found.");
            }

            System.out.println("After update:");
            productDAO.getAllProducts();

        } catch (SQLException e) {
            System.out.println("Database operation failed.");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());

        }
    }
}
