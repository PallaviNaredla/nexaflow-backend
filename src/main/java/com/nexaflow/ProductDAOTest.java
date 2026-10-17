
package com.nexaflow;

import com.nexaflow.dao.ProductDAO;
import java.sql.SQLException;

public class ProductDAOTest {

    public static void main(String[] args) {

        ProductDAO productDAO = new ProductDAO();

        try {
            System.out.println("Fetching all products...");
            productDAO.getAllProducts();

        } catch (SQLException e) {
            System.out.println("Failed to retrieve products.");
            e.printStackTrace();
        }
    }
}
