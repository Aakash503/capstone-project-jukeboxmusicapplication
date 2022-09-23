package com.jap.repository;


import com.jap.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongRepository implements SongRepositoryInterface<Song> {


    @Override
    public boolean addSong(Connection connection, Song Song) throws SQLException {
        String insertQuery = "INSERT INTO `jukebox`.`songs` " + "( `songName`, `albumName`,`genre`,`artistName`,`songPath`) " + "VALUES ( ?, ?,?,?,?);";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, Song.getSongName());
            preparedStatement.setString(2, Song.getAlbumName());
            preparedStatement.setString(3, Song.getGenre());
            preparedStatement.setString(4, Song.getArtistName());
            preparedStatement.setString(5, Song.getSongPath());

            numberOfRowsAffected = preparedStatement.executeUpdate();

        }
        return numberOfRowsAffected > 0;
    }

    public List<Song> displayAllSongs(Connection connection) throws SQLException {

        String readQuery = "SELECT * FROM `jukebox`.`songs`;";
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

                Song Song = new Song(songName, albumName, genre, artistName, songPath);
                songList.add(Song);
            }
        }

        return songList;
    }

    @Override
    public Song findSongByArtistName(Connection connection, String artistName) throws SQLException {
        String searchQuery = "SELECT * FROM `jukebox`.`songs` WHERE(`artistName` = ?);";
        Song Song = new Song();

        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {

            preparedStatement.setString(1, artistName);
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

                // create a song object using the values fetched from the result set
                Song = new Song(songName, albumName, genre, artist, songPath);
            }
        }
        return Song;

    }

    @Override
    public Song findSongBySongId(Connection connection, int id) throws SQLException {
        String searchQuery = "SELECT * FROM `jukebox`.`songs` WHERE(`genre` = ?);";
        Song Song = new Song();

        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {

            preparedStatement.setInt(1, id);
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

                Song = new Song(songName, albumName, genre, artist, songPath);

            }

        }
        return Song;
    }

}
