package com.jap.repository;

import java.sql.Connection;
import java.sql.SQLException;

public interface PlaylistRepository1 {
    void createListOfPlaylist(Connection connection, String listName) throws SQLException;
}
