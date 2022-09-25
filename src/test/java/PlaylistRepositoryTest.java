import com.jap.model.Song;
import com.jap.repository.PlaylistRepository;
import com.jap.service.DatabaseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

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
//            Song output = playlistRepository.findSongInPlaylist(connection,);
//            Song expectedOutput = playlistRepository.findSongInPlaylist(connection,);
            Assertions.assertTrue(playlistRepository.addSongInPlayList(connection,
                    "myfavorate", 8), "given song is added in the playlist");
        }


    }
