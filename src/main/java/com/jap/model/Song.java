package com.jap.model;

public class Song {
    private int songId;
    private String songName;
    private String albumName;
    private String genre;
    private String songPath;

    public Song() {
    }

    public Song(int songId, String songName, String albumName, String genre, String songPath) {
        this.songId = songId;
        this.songName = songName;
        this.albumName = albumName;
        this.genre = genre;
        this.songPath = songPath;
    }

}
