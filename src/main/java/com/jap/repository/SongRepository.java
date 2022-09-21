package com.jap.repository;


import com.jap.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongRepository implements SongRepositoryInterface<Song> {


    @Override
    public boolean addSong(Connection connection, Song song) throws SQLException {
        String insertQuery = "INSERT INTO `jukebox`.`songs` " + "(`songId`, `songName`, `albumName`,`genre`,`artistName`,`songPath`) " + "VALUES (?, ?, ?,?,?,?);";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            // 3. set the values of the query parameters
            preparedStatement.setInt(1, song.getSongId());
            preparedStatement.setString(2, song.getSongName());
            preparedStatement.setString(3, song.getAlbumName());
            preparedStatement.setString(4, song.getGenre());
            preparedStatement.setString(5, song.getArtistName());
            preparedStatement.setString(6, song.getSongPath());

            // 4. execute the query
            numberOfRowsAffected = preparedStatement.executeUpdate();


        }
        return numberOfRowsAffected > 0;
    }

    public List<Song> displayAllSongs(Connection connection) throws SQLException {
        // 1. write the query for selecting all the song objects from the `songs` table
        String readQuery = "SELECT * FROM `jukebox`.`songs`;";

        List<Song> songList = new ArrayList<>();

        // 2. create a statement object
        try (Statement statement = connection.createStatement()) {

            // 3. execute the query
            ResultSet songsResultSet = statement.executeQuery(readQuery);

            // 4. iterate over the result set and create a list of song objects
            while (songsResultSet.next()) {
                // 5. fetch the values of the current row from the result set
                int songId = songsResultSet.getInt("id");
                String songName = songsResultSet.getString("songName");
                String albumName = songsResultSet.getString("albumName");
                String genre = songsResultSet.getString("genre");
                String artistName = songsResultSet.getString("artistName");
                String songPath = songsResultSet.getString("songPath");

                // 6. create a song object using the values fetched from the result set
                Song song = new Song(songId, songName, albumName, genre, artistName, songPath);

                // 7. add the songs object to the list
                songList.add(song);
            }
        }

        return songList;
    }

    @Override
    public Song findSongByArtistName(Connection connection, String artistName) throws SQLException {
        return null;
    }


}
