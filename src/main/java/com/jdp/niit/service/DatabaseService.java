package com.jdp.niit.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    private static final String url = "jdbc:mysql://localhost:3306/jukebox";
    private static final String userName = "root";
    private static final String password = "Admin@123";

    private Connection connection;

    public DatabaseService() {
    }

    public DatabaseService(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(url, userName, password);
    }

    public void printConnectionStatus() {
        if (connection != null) {
            System.out.println("\u001B[32m Database is connected. \u001B[0m");
        } else {
            System.err.println("Database is not connected");
        }
    }

}
