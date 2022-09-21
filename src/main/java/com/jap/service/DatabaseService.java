package com.jap.service;

import java.sql.Connection;

public class DatabaseService {
    private final String Url = "jdbc:mysql://localhost:3306/jukebox";
    private final String USERNAME = "root";
    private final String PASSWORD = "Admin@123";

    private Connection connection;

    public DatabaseService(Connection connection) {
        this.connection = connection;
    }
}
