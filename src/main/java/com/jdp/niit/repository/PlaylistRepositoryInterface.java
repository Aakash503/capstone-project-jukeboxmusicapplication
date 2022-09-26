package com.jdp.niit.repository;

import com.jdp.niit.model.Song;

import java.sql.Connection;
import java.sql.SQLException;

public interface PlaylistRepositoryInterface {


    void createPlayList(Connection connection, String playListName) throws SQLException;

    boolean addSongInPlayList(Connection connection, String playListName, int songId) throws SQLException;

    Song findSongInPlaylist(Connection connection, String playListName, int songID) throws SQLException;

    boolean removeSongFromPlayList(Connection connection, String playListName, int songId) throws SQLException;
}
