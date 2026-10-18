package com.nexaflow.dao;

import com.nexaflow.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {

    public boolean insertProduct(
            int productId,
            String productName,
            double price,
            int quantity
    ) throws SQLException {

        String sql = "INSERT INTO products " +
                "(product_id, product_name, price, available_quantity) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, productId);
            ps.setString(2, productName);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);

            int rowsInserted = ps.executeUpdate();

            return rowsInserted == 1;
        }
    }

    public boolean updateProduct(int productId, double price, int quantity)
            throws SQLException {

        if (productId <= 0) {
            throw new IllegalArgumentException("Product ID must be positive.");
        }

        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }

        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }

        String sql = "UPDATE products SET price = ?, available_quantity = ? "
                + "WHERE product_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setDouble(1, price);
            ps.setInt(2, quantity);
            ps.setInt(3, productId);

            int rowsUpdated = ps.executeUpdate();

            return rowsUpdated == 1;
        }
    }

    public void getAllProducts() throws SQLException {

        String sql = "SELECT product_id, product_name, " +
                "price, available_quantity FROM products";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            boolean found = false;

            while (rs.next()) {
                found = true;

                int productId = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("available_quantity");

                System.out.println("Product ID: " + productId);
                System.out.println("Product Name: " + productName);
                System.out.println("Price: " + price);
                System.out.println("Available Quantity: " + quantity);
                System.out.println("------------------------------");
            }

            if (!found) {
                System.out.println("No products found.");
            }
        }
    }
}
