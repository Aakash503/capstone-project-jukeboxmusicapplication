package com.jap;

import com.jap.model.Song;
import com.jap.repository.PlaylistRepository;
import com.jap.repository.SongRepository;
import com.jap.service.DatabaseService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice;

        do {

            System.out.println("Welcome to the song playlist");

            System.out.println("1. Add a new song");
            System.out.println("2. View all songs");
            System.out.println("3. find a song by artistName");
            System.out.println("4. find a song by songId");
            System.out.println("5. Create a new playlist");
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            DatabaseService databaseService = new DatabaseService();

            try {
                databaseService.connect();

                SongRepository songRepository = new SongRepository();
                PlaylistRepository playlistRepository = new PlaylistRepository();

                Connection connection = databaseService.getConnection();

                switch (choice) {
                    case 1:
                        System.out.println("Add a new song");

                        System.out.println("Enter the song name: ");

                        String songName = scanner.next();

                        System.out.println("Enter the albumName: ");

                        String albumName = scanner.next();

                        System.out.println("Enter the songGenre: ");

                        String genre = scanner.next();
                        System.out.println("Enter the artistName: ");
                        String artistName = scanner.next();
                        System.out.println("Enter the songPath: ");
                        String songPath = scanner.next();

                        Song Song = new Song(songName, albumName, genre, artistName, songPath);

                        songRepository.addSong(connection, Song);
                        break;
                    case 2:
                        System.out.println("view all songs");

                        songRepository.displayAllSongs(connection).forEach(System.out::println);

                        break;
                    case 3:
                        System.out.println("find a song by Artist Name");

                        System.out.println("Enter song Artist name: ");

                        String artist = scanner.next();

                        Song song1 = songRepository.findSongByArtistName(connection, artist);

                        if (song1.getArtistName().equalsIgnoreCase(artist)) {
                            System.out.println(song1);
                        } else {
                            System.err.println("No song found in the list");
                        }

                        break;

                    case 4:

                        System.out.println("Enter songId: ");
                        int id = scanner.nextInt();
                        Song song2 = songRepository.findSongBySongId(connection, id);
                        if (song2.getSongId() == id) {
                            System.out.println(song2);
                        } else {
                            System.err.println("No song found in the list");
                        }

                        break;
                    case 5:
                        System.out.println("Enter the playlist name you want to create");
                        String playlistName = scanner.next();
                        playlistRepository.createPlayList(connection, playlistName);
                        break;

                    case 6:
                        System.out.println("Exit");
                        break;
                    default:
                        System.err.println("Invalid choice");
                }

            } catch (SQLException exception) {
                System.err.println("Could not connect to the database!");
                exception.printStackTrace();
            }

        } while (choice != 6);
    }

}
