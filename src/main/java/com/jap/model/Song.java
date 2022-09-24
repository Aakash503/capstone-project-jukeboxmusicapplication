package com.jap.model;

import java.util.Objects;

public class Song {
    private int id;
    private String songName;
    private String albumName;
    private String genre;
    private String artistName;
    private String songPath;

    public Song() {
    }

    public Song(String songName, String albumName, String genre, String artistName, String songPath) {
        this.songName = songName;
        this.albumName = albumName;
        this.genre = genre;
        this.artistName = artistName;
        this.songPath = songPath;
    }
    public Song(int id, String songName, String albumName, String genre, String artistName, String songPath) {
        this.id = id;
        this.songName = songName;
        this.albumName = albumName;
        this.genre = genre;
        this.artistName = artistName;
        this.songPath = songPath;
    }

    public int getSongId() {
        return id;
    }


    public String getSongName() {
        return songName;
    }


    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getGenre() {
        return genre;
    }


    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }

    public String getArtistName() {
        return artistName;
    }



    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return id == song.id && songName.equals(song.songName) && albumName.equals(song.albumName) &&
                genre.equals(song.genre) && artistName.equals(song.artistName) && songPath.equals(song.songPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, songName, albumName, genre, artistName, songPath);
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songName='" + songName + '\'' +
                ", albumName='" + albumName + '\'' +
                ", genre='" + genre + '\'' +
                ", artistName='" + artistName + '\'' +
                ", songPath='" + songPath + '\'' +
                '}';
    }
}
