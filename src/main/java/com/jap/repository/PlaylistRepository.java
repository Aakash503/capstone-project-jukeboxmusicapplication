package com.jap.repository;

import com.jap.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PlaylistRepository implements PlaylistRepositoryInterface {

    /**
     * It creates a new table in the database with the name of the playlist
     *
     * @param connection   Connection object
     * @param playListName The name of the playlist to be created.
     */
    @Override
    public void createPlayList(Connection connection, String playListName) throws SQLException {
        String playListQuery = "CREATE TABLE `" + playListName + "` (`songId` INT NOT NULL PRIMARY KEY ," +
                "`songName` VARCHAR(100),`albumName` VARCHAR(100),`genre` VARCHAR(100),`artistName` VARCHAR(100)," +
                "`songPath`VARCHAR(100));";
        try (Statement statement = connection.createStatement()) {
            statement.execute(playListQuery);
        }
    }

    /**
     * This function adds a song to a playlist
     *
     * @param connection   Connection object
     * @param playListName The name of the playlist to which the song is to be added.
     * @param songId       The id of the song to be added to the playlist.
     * @return The method returns a boolean value.
     */
    @Override
    public boolean addSongInPlayList(Connection connection, String playListName, int songId) throws SQLException {

        String insertQuery = "INSERT INTO`" + playListName + "` (`songId`,`songName`,`albumName`,`genre`,`artistName`,`songPath`)"
                + "select * From `jukebox`.`songs`where`songId`=?";

        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, songId);
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }

    /**
     * It removes a song from a playlist
     *
     * @param connection   The connection object to the database.
     * @param playListName The name of the playlist from which the song is to be removed.
     * @param songId       The id of the song to be removed from the playlist.
     * @return The method returns a boolean value.
     */
    @Override
    public boolean removeSongFromPlayList(Connection connection, String playListName, int songId) throws SQLException {
        String removeQuery = "DELETE FROM `jukebox`.`" + playListName + "` WHERE (`songId` = ?);";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(removeQuery)) {
            preparedStatement.setInt(1, songId);
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }


    public Song findSongInPlaylist(Connection connection, String playListName, int songID) throws SQLException {
        String searchQuery = "SELECT * FROM `jukebox`.`" + playListName + "` WHERE(`songId` = ?);";
        Song song = new Song();

        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {

            preparedStatement.setInt(1, songID);
            ResultSet songsResultSet = preparedStatement.executeQuery();

            // check if the result set is empty
            while (songsResultSet.next()) {
                //  fetch the values of the current row from the result set
                int songId = songsResultSet.getInt("songId");
                String songName = songsResultSet.getString("songName");
                String albumName = songsResultSet.getString("albumName");
                String genre = songsResultSet.getString("genre");
                String artist = songsResultSet.getString("artistName");
                String songPath = songsResultSet.getString("songPath");

                song = new Song(songId, songName, albumName, genre, artist, songPath);

            }

        }
        System.out.println("given song is added in the playlist");
        return song;
    }

    public List<Song> displayAllSongsInPlaylist(Connection connection, String playListName) throws SQLException {

        String readQuery = "SELECT * FROM `jukebox`.`" + playListName + "`;";
        List<Song> songList = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {

            ResultSet songsResultSet = statement.executeQuery(readQuery);
            while (songsResultSet.next()) {

                int songId = songsResultSet.getInt("songId");
                String songName = songsResultSet.getString("songName");
                String albumName = songsResultSet.getString("albumName");
                String genre = songsResultSet.getString("genre");
                String artistName = songsResultSet.getString("artistName");
                String songPath = songsResultSet.getString("songPath");

                Song song = new Song(songId, songName, albumName, genre, artistName, songPath);
                songList.add(song);
            }
        }
        return songList;
    }

    PlaylistRepository1 playlistRepository1 = new PlaylistRepository1() {
        @Override
        public void createListOfPlaylist(Connection connection, String listName) {

        }
    };

}






