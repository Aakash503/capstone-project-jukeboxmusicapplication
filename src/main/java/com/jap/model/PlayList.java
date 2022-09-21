package com.jap.model;

import java.util.Objects;

public class PlayList {
    private int playlistId;
    private String playlistName;

    public PlayList() {
    }

    public PlayList(int playlistId, String playlistName) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayList playList = (PlayList) o;
        return playlistId == playList.playlistId && playlistName.equals(playList.playlistName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlistId, playlistName);
    }

    @Override
    public String toString() {
        return "PlayList{" + "playlistId=" + playlistId + ", playlistName='" + playlistName + '\'' + '}';
    }
}
