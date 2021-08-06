import org.junit.jupiter.api.Test;
import snakegame.Game;
import snakegame.SnakeGame;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    void world_exists() {
        Game game = new SnakeGame();

        assertThat(game.world()).isNotNull();
    }

}

