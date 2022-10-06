package com.jdp.niit.repository;

import com.jdp.niit.model.Song;
import com.jdp.niit.songexception.SongsException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repository {
    List<Song> displayAllSongs(Connection connection) throws SQLException;

    boolean removeSong(Connection connection, int songId) throws SQLException, SongsException;
}
