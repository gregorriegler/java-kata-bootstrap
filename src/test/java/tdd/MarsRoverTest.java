package tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MarsRoverTest {

    @Test
    void initializes() {
        var rover = new MarsRover();

        assertThat(rover.facing()).isEqualTo(Direction.NORTH);
        assertThat(rover.position()).isEqualTo(new Position(0, 0));
    }

    @ParameterizedTest(name = "rover turning \"{0}\" faces {1} at ({2},{3})")
    @CsvSource({
        "'',NORTH,0,0",
        
        "r,EAST,0,0",
        "rr,SOUTH,0,0",
        "rrr,WEST,0,0",
        "rrrr,NORTH,0,0",

        "l,WEST,0,0",
        "ll,SOUTH,0,0",
        "lll,EAST,0,0",
        "llll,NORTH,0,0",
    })
    public void turns(String commands, Direction expectedFacing, int expectedX, int expectedY) {
        var rover = new MarsRover();

        rover.sendCommands(commands);

        assertThat(rover.facing()).isEqualTo(expectedFacing);
        assertThat(rover.position()).isEqualTo(new Position(expectedX, expectedY));
    }

}
