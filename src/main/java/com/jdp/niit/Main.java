package com.jdp.niit;

import com.jdp.niit.model.PlayList;
import com.jdp.niit.model.Song;
import com.jdp.niit.repository.PlaylistRepository;
import com.jdp.niit.repository.SongRepository;
import com.jdp.niit.repository.SongsException;
import com.jdp.niit.service.DatabaseService;
import com.jdp.niit.service.MusicPlayerService;

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
            System.out.println("4. Find a song by artistName");
            System.out.println("5. Find a song by songId");
            System.out.println("6. Create a new playlist");
            System.out.println("7. Create a list of playlist");
            System.out.println("8. Add a song in your playlist");
            System.out.println("9. Play a song");
            System.out.println("10. Delete a song from playlist");
            System.out.println("11. Delete Song from songs");
            System.out.println("12. to store your playlist ");

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

                        boolean c = songRepository.addSong(connection, s1);
                        System.out.println(c);
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
                        System.out.println("Enter the catalogue name of playlists ");
                        String name1 = scanner.next();
                        playlistRepository.listCreater(connection, name1);
                        break;

                    case 8:
                        System.out.println("Enter the playlist name");
                        String playListName = scanner.next();
                        System.out.println("Enter the songId");
                        int id = scanner.nextInt();
                        boolean b = playlistRepository.addSongInPlayList(connection, playListName, id);
                        System.out.println(b);
                        break;

                    case 9:
                        System.out.println("Enter playlist name");
                        String n1 = scanner.next();
                        System.out.println("enter songId");
                        int sid = scanner.nextInt();
                        String path = playlistRepository.findSongInPlaylist(connection, n1, sid).getSongPath();
                        MusicPlayerService musicPlayerService = new MusicPlayerService();
                        musicPlayerService.play(path);
                        break;

                    case 10:
                        System.out.println("Enter the playlist name");
                        String name = scanner.next();
                        System.out.println("Enter the songId");
                        int snid = scanner.nextInt();
                        boolean result = playlistRepository.removeSongFromPlayList(connection, name, snid);
                        System.out.println(result);
                        break;

                    case 11:
                        System.out.println("enter the songId of Song you want to delete");
                        int sid1 = scanner.nextInt();
                        boolean b1 = songRepository.removeSongFromSongs(connection, sid1);
                        System.out.println(b1);
                        break;

                    case 12:

                        System.out.println("enter the your playlistId");
                        int id1 = scanner.nextInt();
                        System.out.println("Enter your playlist name");
                        String listName = scanner.next();
                        PlayList p1 = new PlayList(id1, listName);
                        playlistRepository.addPlaylistInList(connection, p1);
                        break;

                    case 13:
                        System.out.println("Exit");
                        break;
                    default:
                        System.err.println("Invalid choice");
                }

            } catch (SQLException exception) {
                System.err.println("Could not connect to the database!");
                exception.printStackTrace();
            } catch (SongsException exception) {
                System.out.println(exception.getMessage());
            }

        } while (choice != 13);
    }

}
