package com.jap.repository;

import java.sql.Connection;

public interface SongRepositoryInterface<T> {
    boolean addSong(Connection connection, T object);
}
