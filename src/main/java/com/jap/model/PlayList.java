package com.jap.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayList {
    private int id;
    private String name;
    private Song Song;
    private List<Song> list;

    public PlayList() {
        list = new ArrayList<>();
    }

    public PlayList(int id, String name, Song Song) {
        this.id = id;
        this.name = name;
        this.Song = Song;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getList() {
        return list;
    }

    public void setList(List<Song> list) {
        this.list = list;
    }

    public Song getSong() {
        return Song;
    }

    public void setSong(Song Song) {
        this.Song = Song;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayList playList = (PlayList) o;
        return id == playList.id && name.equals(playList.name) && Song.equals(playList.Song) && list.equals(playList.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, Song, list);
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", song=" + Song +
                ", list=" + list +
                '}';
    }
}

