package com.jap.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    private final String URL = "jdbc:mysql://localhost:3306/jukebox";
    private final String USERNAME = "root";
    private final String PASSWORD = "Admin@123";

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
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
