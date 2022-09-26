import com.jdp.niit.model.Song;
import com.jdp.niit.repository.SongRepository;
import com.jdp.niit.repository.SongsException;
import com.jdp.niit.service.DatabaseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


class SongRepositoryTest {
    SongRepository songRepository = null;
    Song song;
    DatabaseService databaseService = new DatabaseService();

    @BeforeEach
    void setUp() {
        songRepository = new SongRepository();
        song = new Song();
        databaseService = new DatabaseService();
    }

    @AfterEach
    void tearDown() {
        songRepository = null;
        song = null;
    }

    @Test
    void getSongById() throws SQLException, SongsException {
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        Song output = songRepository.findSongBySongId(connection, 1);
        Song expectedOutput = songRepository.findSongBySongId(connection, output.getSongId());
        Assertions.assertEquals(expectedOutput, output);
    }

    @Test
    void removeSong() throws SQLException, SongsException {
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        boolean Output = songRepository.removeSongFromSongs(connection, 13);
        Assertions.assertTrue(Output);

    }

    @Test
    void getSongByArtistName() throws SQLException {
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        Song actual = songRepository.findSongByArtistName(connection, "arijitsingh");
        Song expected = songRepository.findSongByArtistName(connection, actual.getArtistName());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addMethod() throws SQLException {
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        Song song1 = new Song("aaaa", "nnn", "ggg", "ryan", "ipp");
        Assertions.assertTrue(songRepository.addSong(connection, song1));

    }

    @Test
    void getAllSongs() throws SQLException {
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        List<Song> output = songRepository.displayAllSongs(connection);
        List<Song> expectedOutput = songRepository.displayAllSongs(connection);
        Assertions.assertEquals(expectedOutput, output);
    }

}

