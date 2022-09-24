package com.jap;

import com.jap.model.Song;
import com.jap.repository.PlaylistRepository;
import com.jap.repository.SongRepository;
import com.jap.service.DatabaseService;
import com.jap.service.MusicPlayerService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice;

        do {

            System.out.println("Welcome to the song playlist");

            System.out.println("1. Add a new song");
            System.out.println("2. View all songs in songList");
            System.out.println("3. View all songs in your playList");
            System.out.println("4. find a song by artistName");
            System.out.println("5. find a song by songId");
            System.out.println("6. Create a new playlist");
            System.out.println("7. Add a song in your playlist");
            System.out.println("8. to play a song");
            System.out.println("9. to delete a song from playlist");
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

                        Song s1 = new Song(songName, albumName, genre, artistName, songPath);

                        songRepository.addSong(connection, s1);
                        break;

                    case 2:
                        System.out.println("view all songs");
                        songRepository.displayAllSongs(connection).forEach(System.out::println);
                        break;

                    case 3:
                        System.out.println("Enter your Playlist name");
                        String playlistName = scanner.next();
                        playlistRepository.displayAllSongsInPlaylist(connection, playlistName).forEach(System.out::println);
                        break;

                    case 4:
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

                    case 5:
                        System.out.println("Enter songId: ");
                        int songId = scanner.nextInt();
                        Song song2 = songRepository.findSongBySongId(connection, songId);
                        if (songId == song2.getSongId()) {
                            System.out.println(song2);
                        } else {
                            System.err.println("No song found in the list");
                        }
                        break;

                    case 6:
                        System.out.println("Enter the playlist name you want to create");
                        String playlist = scanner.next();
                        playlistRepository.createPlayList(connection, playlist);
                        break;

                    case 7:
                        System.out.println("Enter the playlist name");
                        String playlist_Name = scanner.next();
                        System.out.println("Enter the songId");
                        int id = scanner.nextInt();
                        playlistRepository.addSongInPlayList(connection, playlist_Name, id);
                        break;

                    case 8:
                        System.out.println("Enter playlist name");
                        String n1 = scanner.next();
                        System.out.println("enter songId");
                        int sid = scanner.nextInt();
                        String path = playlistRepository.findSongInPlaylist(connection, n1, sid).getSongPath();
                        MusicPlayerService musicPlayerService = new MusicPlayerService();
                        musicPlayerService.play(path);
                        break;

                    case 9:
                        System.out.println("Enter the playlist name");
                        String name = scanner.next();
                        System.out.println("Enter the songId");
                        int song_d = scanner.nextInt();
                        boolean result = playlistRepository.removeSongFromPlayList(connection, name, song_d);
                        System.out.println(result);
                        break;
                    case 10:
                        System.out.println("Exit");
                        break;
                    default:
                        System.err.println("Invalid choice");

                }

            } catch (SQLException exception) {
                System.err.println("Could not connect to the database!");
                exception.printStackTrace();
            }

        } while (choice != 10);
    }

}
