package com.jdp.niit.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface SongRepositoryInterface<Song> {

    boolean addSong(Connection connection, Song song) throws SQLException;

    List<Song> displayAllSongs(Connection connection) throws SQLException;

    Song findSongByArtistName(Connection connection, String artistName) throws SQLException;

    Song findSongBySongId(Connection connection, int id) throws SQLException, SongsException;


}
