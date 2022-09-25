package com.jap.repository;


import com.jap.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongRepository implements SongRepositoryInterface<Song> {


    @Override
    public boolean addSong(Connection connection, Song song) throws SQLException {
        String insertQuery = "INSERT INTO `jukebox`.`songs` " + "( `songName`, `albumName`,`genre`,`artistName`,`songPath`) " + "VALUES ( ?, ?,?,?,?);";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, song.getSongName());
            preparedStatement.setString(2, song.getAlbumName());
            preparedStatement.setString(3, song.getGenre());
            preparedStatement.setString(4, song.getArtistName());
            preparedStatement.setString(5, song.getSongPath());

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

                int songId1 = songsResultSet.getInt("songId");
                String songName1 = songsResultSet.getString("songName");
                String albumName1 = songsResultSet.getString("albumName");
                String genre1 = songsResultSet.getString("genre");
                String artistName1 = songsResultSet.getString("artistName");
                String songPath1 = songsResultSet.getString("songPath");

                Song song = new Song(songId1, songName1, albumName1, genre1, artistName1, songPath1);
                songList.add(song);
            }
        }

        return songList;
    }

    @Override
    public Song findSongByArtistName(Connection connection, String artistName) throws SQLException {
        String searchQuery = "SELECT * FROM `jukebox`.`songs` WHERE(`artistName` = ?);";
        Song song = new Song();

        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {

            preparedStatement.setString(1, artistName);
            ResultSet songsResultSet = preparedStatement.executeQuery();

            // check if the result set is empty
            while (songsResultSet.next()) {
                //  fetch the values of the current row from the result set
                int songId = songsResultSet.getInt("song_Id");
                String songName = songsResultSet.getString("song_Name");
                String albumName = songsResultSet.getString("album_Name");
                String genre = songsResultSet.getString("genre1");
                String artist = songsResultSet.getString("artist_Name");
                String songPath = songsResultSet.getString("song_Path");

                // create a song object using the values fetched from the result set
                song = new Song(songId, songName, albumName, genre, artist, songPath);
            }
        }
        return song;

    }

    @Override
    public Song findSongBySongId(Connection connection, int id) throws SQLException {
        String searchQuery = "SELECT * FROM `jukebox`.`songs` WHERE(`songId` = ?);";
        Song song = new Song();

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

                song = new Song(songId, songName, albumName, genre, artist, songPath);

            }

        }
        return song;
    }

    public boolean removeSongFromSongs(Connection connection, int songId) throws SQLException {
        String removeQuery = "DELETE FROM `jukebox`.`songs` WHERE (`songId` = ?);";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(removeQuery)) {
            preparedStatement.setInt(1, songId);
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }


}
