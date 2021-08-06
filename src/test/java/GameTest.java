import org.junit.jupiter.api.Test;
import snakegame.Game;
import snakegame.Size;
import snakegame.Snake;
import snakegame.SnakeGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void snake_moves_east() {
        Game game = new SnakeGame(size);
        Snake snake = game.world().getSnake();

        // preconditions
        assertThat(snake.getHeadX()).isEqualTo(0);
        assertThat(snake.getHeadY()).isEqualTo(0);
        assertEquals(Snake.Direction.EAST, snake.getDirection());

        // Action
        snake.move();

        assertThat(snake.getHeadX()).isEqualTo(1);
        assertThat(snake.getHeadY()).isEqualTo(0);
    }

    @Test
    void snake_turns_south() {
        Game game = new SnakeGame(size);
        Snake snake = game.world().getSnake();

        snake.turnSouth();

        assertThat(snake.getHeadX()).isEqualTo(0);
        assertThat(snake.getHeadY()).isEqualTo(0);
        assertEquals(Snake.Direction.SOUTH, snake.getDirection());
    }

    @Test
    void snake_moves_south() {
        Game game = new SnakeGame(size);
        Snake snake = game.world().getSnake();

        snake.turnSouth();
        snake.move();

        assertThat(snake.getHeadX()).isEqualTo(0);
        assertThat(snake.getHeadY()).isEqualTo(1);
    }

    @Test
    void snake_grows_after_eating_apple() {
        // Snake 0,0 (Length 1)
        // Apple 1,0

        Game game = new SnakeGame(size);
        Snake snake = game.world().getSnake();
        int currentSnakeSize = snake.getLength();

        snake.move();

        assertThat(snake.getLength()).isEqualTo(currentSnakeSize+1);
    }
}

