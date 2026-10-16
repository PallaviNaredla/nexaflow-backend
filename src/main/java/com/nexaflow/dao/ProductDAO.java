package com.nexaflow.dao;

import com.nexaflow.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
