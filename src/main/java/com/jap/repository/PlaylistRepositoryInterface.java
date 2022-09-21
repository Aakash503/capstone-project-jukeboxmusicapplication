package com.jap.repository;

import com.jap.model.PlayList;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface PlaylistRepositoryInterface {
     boolean add(Connection connection, PlayList playlist) throws SQLException;

     List<PlayList> getAll(Connection connection) throws SQLException;

     PlayList getByPlaylistName(Connection connection, String playlist_name) throws SQLException;

     boolean updatePlaylistId(Connection connection, int id) throws SQLException;

     boolean deleteById(Connection connection, int id) throws SQLException;

}
