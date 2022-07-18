package tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class MarsRoverTest {

    @Test
    void initializes() {
        var rover = new MarsRover();

        assertThat(rover.facing()).isEqualTo(Direction.NORTH);
        assertThat(rover.position()).isEqualTo(new Position(0, 0));
    }
    
    @ParameterizedTest(name = "rover turning '{0}' faces {1} at ({2},{3})")
    @CsvSource({
        "'',NORTH,0,0"
    })
    public void turns(String commands, Direction expectedFacing, int expectedX, int expectedY) {
        var rover = new MarsRover();
        
        rover.sendCommands(commands);
        
        assertThat(rover.facing()).isEqualTo(expectedFacing);
        assertThat(rover.position()).isEqualTo(new Position(expectedX, expectedY));
    }

    private enum Direction {
        NORTH

    }

    private static class Position {
        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private class MarsRover {
        public void sendCommands(String commands) {

        }

        public Direction facing() {
            return Direction.NORTH;
        }

        public Position position() {
            return new Position(0, 0);
        }
    }
}
