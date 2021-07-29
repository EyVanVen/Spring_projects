package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "92837";
        System.out.println("Connecting...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection: " + !connection.isClosed());
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}
