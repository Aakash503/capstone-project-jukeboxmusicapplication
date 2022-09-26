import com.jdp.niit.model.Song;
import com.jdp.niit.repository.PlaylistRepository;
import com.jdp.niit.service.DatabaseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

class PlaylistRepositoryTest {
    PlaylistRepository playlistRepository = null;
    Song song;
    DatabaseService databaseService = new DatabaseService();

    @BeforeEach
    void setUp() {
        playlistRepository = new PlaylistRepository();
        song = new Song();
        databaseService = new DatabaseService();
    }

    @AfterEach
    void tearDown() {
        playlistRepository = null;
        song = null;
    }

        @Test
        void addMethod() throws SQLException {
            databaseService.connect();
            Connection connection = databaseService.getConnection();
            Assertions.assertTrue(playlistRepository.addSongInPlayList(connection, "myfavorate", 1));

        }

        @Test
        void getSongById() throws SQLException {
            databaseService.connect();
            Connection connection = databaseService.getConnection();
            Assertions.assertTrue(playlistRepository.addSongInPlayList(connection,
                    "myfavorate", 7), "given song is added in the playlist");
        }

    @Test
    void deleteSongFromPlaylist() throws SQLException {
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        boolean Output = playlistRepository.removeSongFromPlayList(connection, "myfavorate", 7);
        Assertions.assertTrue(Output);

    }

    @Test
    void getAllSongs() throws SQLException {
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        List<Song> output = playlistRepository.displayAllSongsInPlaylist(connection, "myfavorate");
        List<Song> expectedOutput = playlistRepository.displayAllSongsInPlaylist(connection, "myfavorate");
        Assertions.assertEquals(expectedOutput, output);
    }
}
