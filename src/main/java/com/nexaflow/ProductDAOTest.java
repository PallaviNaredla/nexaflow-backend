
package com.nexaflow;

import com.nexaflow.dao.ProductDAO;
import java.sql.SQLException;

public class ProductDAOTest {

    public static void main(String[] args) {

        ProductDAO productDAO = new ProductDAO();

        try {
            System.out.println("Products before deletion:");
            productDAO.getProductById(999);

            boolean deleted = productDAO.deleteProduct(104);

            if (deleted) {
                System.out.println(
                        "Product deleted successfully."
                );
            } else {
                System.out.println(
                        "Product ID not found."
                );
            }

            System.out.println("Products after deletion:");
            productDAO.getAllProducts();

        } catch (SQLException e) {
            System.out.println("Database operation failed.");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }
}
