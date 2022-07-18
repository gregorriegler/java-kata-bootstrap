package tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MarsRoverTest {

    @Test
    void hello() {
        var rover = new MarsRover();

        assertThat(rover.facing()).isEqualTo(Direction.NORTH);
    }

    private class MarsRover {
        public Direction facing() {
            return Direction.NORTH;
        }
    }
    
    private enum Direction {
        NORTH

    }
}
