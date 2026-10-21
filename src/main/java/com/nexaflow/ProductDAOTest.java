
package com.nexaflow;

import com.nexaflow.dao.ProductDAO;
import java.sql.SQLException;

public class ProductDAOTest {

    public static void main(String[] args) {

        ProductDAO productDAO = new ProductDAO();

        try {
            // Test 1: Search by product name
            System.out.println("TEST 1: Search for Laptop");
            productDAO.searchProductsByName("Laptop");

            // Test 2: Case-insensitive search
            System.out.println("\nTEST 2: Search using uppercase");
            productDAO.searchProductsByName("LAPTOP");

            // Test 3: Search for a product that does not exist
            System.out.println("\nTEST 3: Search for unknown product");
            productDAO.searchProductsByName("XYZUnknown");

            // Test 4: Validate empty search input
            System.out.println("\nTEST 4: Search with empty keyword");

            try {
                productDAO.searchProductsByName("   ");
            } catch (IllegalArgumentException e) {
                System.out.println(
                        "Validation successful: " + e.getMessage()
                );
            }

        } catch (SQLException e) {
            System.out.println("Database operation failed.");
            e.printStackTrace();
        }
    }
}
