
package com.nexaflow.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DBConnection {

    private static final String URL =
            "jdbc:oracle:thin:@//localhost:1521/freepdb1";


    private static final String USERNAME = "NEXAFLOW_APP";

    public static Connection getConnection() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Oracle password: ");
        String password = scanner.nextLine();

        return DriverManager.getConnection(URL, USERNAME, password);
    }
}
