package com.jdp.niit.model;


import java.util.Objects;

public class PlayList {
    private final int id;
    private final String name;
    private Song song;


    public PlayList(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayList playList = (PlayList) o;
        return id == playList.id && name.equals(playList.name) && song.equals(playList.song);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, song);
    }

    @Override
    public String toString() {
        return "PlayList{" + "id=" + id + ", name='" + name + '\'' + ", song=" + song + '}';
    }
}

