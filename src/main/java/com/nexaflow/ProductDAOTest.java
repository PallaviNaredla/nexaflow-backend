
package com.nexaflow;

import com.nexaflow.dao.ProductDAO;
import java.sql.SQLException;

public class ProductDAOTest {

    public static void main(String[] args) {

        ProductDAO productDAO = new ProductDAO();

        try {
            boolean result = productDAO.insertProduct(
                    104,
                    "Headphones",
                    2500.00,
                    20
            );

            if (result) {
                System.out.println("Product inserted successfully!");
            } else {
                System.out.println("Product insertion failed.");
            }

        } catch (SQLException e) {
            System.out.println("Database operation failed.");
            e.printStackTrace();
        }
    }
}
