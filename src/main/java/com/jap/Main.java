package com.jap;

import com.jap.service.DatabaseService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseService databaseService = new DatabaseService();
        try {
            databaseService.connect();
        } catch (SQLException e) {
            System.err.println("Error while connecting to the database");
            e.printStackTrace();
        } finally {
            databaseService.printConnectionStatus();
        }
    }
}