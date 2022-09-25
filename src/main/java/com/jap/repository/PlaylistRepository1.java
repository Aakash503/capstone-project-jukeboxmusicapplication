package com.jap.repository;

import java.sql.Connection;

public interface PlaylistRepository1 {
    void createListOfPlaylist(Connection connection, String listName);
}
