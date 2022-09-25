import com.jap.model.Song;
import com.jap.repository.PlaylistRepository;
import com.jap.service.DatabaseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class PlaylistRepositoryTest {
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
}
