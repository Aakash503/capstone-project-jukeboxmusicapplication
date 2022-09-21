package com.jap.repository;

import com.sun.jdi.connect.spi.Connection;

public interface SongRepositoryInterface {
    boolean addSong(Connection connection);
}
