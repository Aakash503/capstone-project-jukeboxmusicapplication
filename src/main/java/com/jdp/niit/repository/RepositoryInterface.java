package com.jdp.niit.repository;

import java.sql.Connection;
import java.sql.SQLException;

public interface RepositoryInterface {
    void createListOfPlaylist(Connection connection, String listName) throws SQLException;
}
