
package com.nexaflow.dao;

import com.nexaflow.Product;
import com.nexaflow.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {

    // CREATE: Insert a new product
    public boolean insertProduct(int productId, String productName,
                                 double price, int quantity)
            throws SQLException {

        if (productId <= 0 || productName == null
                || productName.trim().isEmpty()
                || price <= 0 || quantity < 0) {
            throw new IllegalArgumentException(
                    "Invalid product details."
            );
        }

        String sql = "INSERT INTO products "
                + "(product_id, product_name, price, available_quantity) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, productId);
            ps.setString(2, productName);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);

            return ps.executeUpdate() == 1;
        }
    }

    // READ: Retrieve all products
    public void getAllProducts() throws SQLException {

        String sql = "SELECT product_id, product_name, price, "
                + "available_quantity FROM products";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            boolean found = false;

            while (rs.next()) {
                found = true;

                Product product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getDouble("price"),
                        rs.getInt("available_quantity")
                );

                product.displayProduct();
                System.out.println("------------------------------");
            }

            if (!found) {
                System.out.println("No products found.");
            }
        }
    }

    // UPDATE: Change a product's price and quantity
    public boolean updateProduct(int productId, double price,
                                 int quantity) throws SQLException {

        if (productId <= 0 || price <= 0 || quantity < 0) {
            throw new IllegalArgumentException(
                    "Invalid product ID, price, or quantity."
            );
        }

        String sql = "UPDATE products "
                + "SET price = ?, available_quantity = ? "
                + "WHERE product_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setDouble(1, price);
            ps.setInt(2, quantity);
            ps.setInt(3, productId);

            return ps.executeUpdate() == 1;
        }
    }

    // DELETE: Delete a product by ID
    public boolean deleteProduct(int productId) throws SQLException {

        if (productId <= 0) {
            throw new IllegalArgumentException(
                    "Product ID must be positive."
            );
        }

        String sql = "DELETE FROM products WHERE product_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, productId);

            return ps.executeUpdate() == 1;
        }
    }

    // READ: Retrieve one product by ID
    public Product getProductById(int productId) throws SQLException {

        if (productId <= 0) {
            throw new IllegalArgumentException(
                    "Product ID must be positive."
            );
        }

        String sql = "SELECT product_id, product_name, price, "
                + "available_quantity FROM products "
                + "WHERE product_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, productId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return new Product(
                            rs.getInt("product_id"),
                            rs.getString("product_name"),
                            rs.getDouble("price"),
                            rs.getInt("available_quantity")
                    );
                }
            }
        }

        return null;
    }
}
