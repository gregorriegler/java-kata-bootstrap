package tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Mars Rover")
public class MarsRoverTest {

    @Test
    void initializes() {
        var rover = new MarsRover();

        assertThat(rover.facing()).isEqualTo(Direction.NORTH);
        assertThat(rover.position()).isEqualTo(new Position(0, 0));
    }

    @Nested
    class Turns {

        @DisplayName("to the right")
        @ParameterizedTest(name = "rover turning \"{0}\" faces {1} at ({2},{3})")
        @CsvSource({
            "'',NORTH,0,0",

            "r,EAST,0,0",
            "rr,SOUTH,0,0",
            "rrr,WEST,0,0",
            "rrrr,NORTH,0,0",
        })
        public void right(String commands, Direction expectedFacing, int expectedX, int expectedY) {
            var rover = new MarsRover();

            rover.sendCommands(commands);

            assertThat(rover.facing()).isEqualTo(expectedFacing);
            assertThat(rover.position()).isEqualTo(new Position(expectedX, expectedY));
        }

        @DisplayName("to the left")
        @ParameterizedTest(name = "rover turning \"{0}\" faces {1} at ({2},{3})")
        @CsvSource({
            "l,WEST,0,0",
            "ll,SOUTH,0,0",
            "lll,EAST,0,0",
            "llll,NORTH,0,0",
        })
        public void left(String commands, Direction expectedFacing, int expectedX, int expectedY) {
            var rover = new MarsRover();

            rover.sendCommands(commands);

            assertThat(rover.facing()).isEqualTo(expectedFacing);
            assertThat(rover.position()).isEqualTo(new Position(expectedX, expectedY));
        }
    }

    @Nested
    class Moves {

        @DisplayName("forward")
        @ParameterizedTest(name = "rover moving \"{0}\" faces {1} at ({2},{3})")
        @CsvSource({
            "f,NORTH,0,-1",
            "ff,NORTH,0,-2",
            "fff,NORTH,0,2",
            
            "rf,EAST,1,0",
            "rff,EAST,2,0",
            "rfff,EAST,-2,0",
            
            "rrf,SOUTH,0,1",
            "rrff,SOUTH,0,2",
            "rrfff,SOUTH,0,-2",
        })
        public void forward(String commands, Direction expectedFacing, int expectedX, int expectedY) {
            var rover = new MarsRover();

            rover.sendCommands(commands);

            assertThat(rover.facing()).isEqualTo(expectedFacing);
            assertThat(rover.position()).isEqualTo(new Position(expectedX, expectedY));
        }
        
        @DisplayName("backwards")
        @ParameterizedTest(name = "rover moving \"{0}\" faces {1} at ({2},{3})")
        @CsvSource({
            "b,NORTH,0,1",
            "bb,NORTH,0,2",
            "bbb,NORTH,0,-2",
        })
        public void backwards(String commands, Direction expectedFacing, int expectedX, int expectedY) {
            var rover = new MarsRover();

            rover.sendCommands(commands);

            assertThat(rover.facing()).isEqualTo(expectedFacing);
            assertThat(rover.position()).isEqualTo(new Position(expectedX, expectedY));
        }
    }
}
