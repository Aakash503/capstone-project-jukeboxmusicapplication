package com.jap.repository;

import java.sql.Connection;
import java.sql.SQLException;

public interface PlaylistRepositoryInterface {


    void createPlayList(Connection connection, String playListName) throws SQLException;

    boolean addSongInPlayList(Connection connection, String playListName, int songId) throws SQLException;

    boolean removeSongFromPlayList(Connection connection, String playListName, int songId) throws SQLException;
}
