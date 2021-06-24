import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SnakeTest {

    @Test
    void game_starts_with_snake_at_position_0() {
        var game = new Game(2, 0);

        assertThat(game.toString()).isEqualTo("x-");
    }

    @Test
    void game_starts_with_snake_at_initial_position() {
        var game = new Game(3, 1);

        assertThat(game.toString()).isEqualTo("-x-");
    }

    @Test
    void game_starts_with_snake_at_position_0_on_large_board() {
        var game = new Game(4, 0);

        assertThat(game.toString()).isEqualTo("x---");
    }

    @Test
    void snake_on_tick_does_nothing_before_initial_direction_set() {
        var game = new Game(2, 0);

        game.tick();

        assertThat(game.toString()).isEqualTo("x-");
    }

    @Test
    void snake_on_tick_moves_one_field_in_set_direction() {
        var game = new Game(2, 0);
        game.setDirection(Game.Direction.RIGHT);

        game.tick();

        assertThat(game.toString()).isEqualTo("-x");
    }

    @Test
    void snake_wraps_around_the_edge() {
        var game = new Game(3, 0);
        game.setDirection(Game.Direction.RIGHT);

        game.tick();
        game.tick();
        game.tick();

        assertThat(game.toString()).isEqualTo("x--");
    }

    @Test
    void snake_changes_direction() {
        var game = new Game(3, 0);
        game.setDirection(Game.Direction.RIGHT);

        game.tick();
        game.tick();

        game.setDirection(Game.Direction.LEFT);
        game.tick();

        assertThat(game.toString()).isEqualTo("-x-");
    }
}
