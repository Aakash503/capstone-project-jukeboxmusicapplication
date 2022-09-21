package com.jap.model;

import java.util.Objects;

public class Song {
    private int id;
    private String songName;
    private String albumName;
    private String genre;
    private String songPath;

    public Song() {
    }

    public Song(int songId, String songName, String albumName, String genre, String songPath) {
        this.id = songId;
        this.songName = songName;
        this.albumName = albumName;
        this.genre = genre;
        this.songPath = songPath;
    }

    public int getSongId() {
        return id;
    }

    public void setSongId(int songId) {
        this.id = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
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

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return id == song.id && songName.equals(song.songName) && albumName.equals(song.albumName) && genre.equals(song.genre) && songPath.equals(song.songPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, songName, albumName, genre, songPath);
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songName='" + songName + '\'' +
                ", albumName='" + albumName + '\'' +
                ", genre='" + genre + '\'' +
                ", songPath='" + songPath + '\'' +
                '}';
    }
}
