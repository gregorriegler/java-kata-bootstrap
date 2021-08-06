import org.junit.jupiter.api.Test;
import snakegame.Game;
import snakegame.Size;
import snakegame.Snake;
import snakegame.SnakeGame;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private final Size size = new Size(10, 10);

    @Test
    void world_exists() {
        Game game = new SnakeGame(size);

        assertThat(game.world()).isNotNull();
    }

    @Test
    void snake_exists() {
        Game game = new SnakeGame(size);
        assertThat(game.world().getSnake()).isNotNull();
    }

    @Test
    void apple_exists() {
        Game game = new SnakeGame(size);
        assertThat(game.world().getApple()).isNotNull();
    }

    @Test
    void world_has_edges() {
        Game game = new SnakeGame(size);
        assertThat(game.world().getSize()).isNotNull();
        assertThat(game.world().getSize().getX()).isGreaterThan(0);
        assertThat(game.world().getSize().getY()).isGreaterThan(0);
    }

    @Test
    void world_has_no_edges() {
        Game game = new SnakeGame(new Size(0, 0));
        assertThat(game.world().getSize()).isNotNull();
        assertThat(game.world().getSize().getX()).isEqualTo(0);
        assertThat(game.world().getSize().getY()).isEqualTo(0);
    }

    @Test
    void snake_moves() {
        Game game = new SnakeGame(size);
        Snake snake = game.world().getSnake();

        assertThat(snake.getHeadX()).isEqualTo(0);
        assertThat(snake.getHeadY()).isEqualTo(0);

        snake.move();

        assertThat(snake.getHeadX()).isEqualTo(1);
        assertThat(snake.getHeadY()).isEqualTo(0);
    }

}

