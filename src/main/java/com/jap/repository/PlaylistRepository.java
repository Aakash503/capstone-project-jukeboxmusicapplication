package com.jap.repository;

import com.jap.model.PlayList;
import com.jap.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistRepository implements PlaylistRepositoryInterface {
    @Override
    public boolean add(Connection connection, PlayList playlist) throws SQLException {
        // write the query for inserting a new playlist object into the `playlist` table
        String insertQuery = "INSERT INTO `JUKEBOX`.`PLAYLIST`" + "(`id`,`NAME`,`NAME`)" + " VALUES (?,?,?);";
        //create a statement object
        int numberOfRowsAffected;
        //set values of the query parameter
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, playlist.getId());
            preparedStatement.setString(2, playlist.getName());
            preparedStatement.setString(3, playlist.getSong().getSongName());
            //set values of the query parameter
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }

    @Override
    public List<PlayList> getAll(Connection connection) throws SQLException {
        //write the query for selecting all the playlist objects from the `PLAYLIST` table
        String readQuery = "SELECT * FROM `jukebox`.`playlist`;";
        List<PlayList> playlistList = new ArrayList<>();
        //create a statement object
        try (Statement statement = connection.createStatement()) {
            //execute the query
            ResultSet playlistResultSet = statement.executeQuery(readQuery);
            //iterate over the result set and create a list of salesperson objects
            while (playlistResultSet.next()) {
                //fetch the values of the current row from the result set
                int playlistId = playlistResultSet.getInt("playlist_id");
                String playlistName = playlistResultSet.getString("playlist_name");
                String songName = playlistResultSet.getString("song_name");
                //create a playlist object using the values fetched from the result set
                PlayList playlist = new PlayList(playlistId, playlistName, new Song());
                //add the playlist object to the list
                playlistList.add(playlist);
            }
        }
        return playlistList;
    }

    @Override
    public PlayList getByPlaylistName(Connection connection, String name) throws SQLException {
        //write the query for selecting a playlist object from the `playlist` table
        String searchQuery = "SELECT * FROM `jukebox`.`playlist` WHERE(`playlist_name` = ?);";
        PlayList playlist = new PlayList();
        //create a statement object
        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            // set the value of query parameters
            preparedStatement.setString(1, name);
            //execute the query
            ResultSet playlistResultSet = preparedStatement.executeQuery();
            //check if the result set is empty
            while (playlistResultSet.next()) {
                //fetch the values of the current row from the result set
                String playlistName = playlistResultSet.getString("name");
                String songName = playlistResultSet.getString("song_name");
                int playlistId = playlistResultSet.getInt("id");
                //create a playlist object using the values fetched from the result set
                playlist = new PlayList(playlistId, songName, new Song());
            }
        }
        return playlist;
    }

    @Override
    public boolean updatePlaylistId(Connection connection, int id) throws SQLException {
        //write the query for selecting a playlist object from the `playlist` table
        String searchQuery = "SELECT * FROM `jukebox`.`playlist` WHERE(`playlist_id` = ?);";
        PlayList playlist = new PlayList();
        // create a statement object
        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            //set the values of the query parameters
            preparedStatement.setInt(1, id);
            //execute the query
            ResultSet playlistResultSet = preparedStatement.executeQuery();
            //check if the result set is empty
            while (playlistResultSet.next()) {
                String playlistName = playlistResultSet.getString("playlist_name");
                String songName = playlistResultSet.getString("song_name");
                int playlistId = playlistResultSet.getInt("playlist_id");
                //create a playlist object using the values fetched from the result set
                playlist = new PlayList();
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(Connection connection, int id) throws SQLException {
        String deleteQuery = "DELETE FROM `jukebox`.`playlist` WHERE (`playlist_id` = ?);";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }
}







