import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class MarsRoverTest {

    @Test
    void initializes_at_1_1_N() {
        var rover = new MarsRover();

        assertThat(rover.position()).isEqualTo(new Position(1, 1));
        assertThat(rover.facing()).isEqualTo(Direction.NORTH);
    }

    @Test
    void invalid_command_throws_exception() {
        var rover = new MarsRover();

        assertThatThrownBy(() -> rover.go("x")).isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    public class Going {
        @ParameterizedTest(name = "going {0} results in ({1},{2}) facing {3}")
        @CsvSource({
            "f   ,1,2,NORTH",
            "ff  ,1,3,NORTH",
            "b   ,1,0,NORTH",
            "bb  ,1,-1,NORTH",
        })
        void can_move(String where, int expectedX, int expectedY, Direction expectedDirection) {
            var rover = new MarsRover();

            rover.go(where);

            assertThat(rover.position()).isEqualTo(new Position(expectedX, expectedY));
            assertThat(rover.facing()).isEqualTo(expectedDirection);
        }
    }

    @Nested
    public class Turning {
        @ParameterizedTest(name = "turning {0} results in ({1},{2}) facing {3}")
        @CsvSource({
            "r   ,1,1,EAST",
            "rr  ,1,1,SOUTH",
            "rrr ,1,1,WEST",
            "rrrr,1,1,NORTH",

            "l   ,1,1,WEST",
            "ll  ,1,1,SOUTH",
            "lll ,1,1,EAST",
            "llll,1,1,NORTH",
        })
        void can_turn(String where, int expectedX, int expectedY, Direction expectedDirection) {
            var rover = new MarsRover();

            rover.go(where);

            assertThat(rover.position()).isEqualTo(new Position(expectedX, expectedY));
            assertThat(rover.facing()).isEqualTo(expectedDirection);
        }

        @Nested
        public class TurningAndGoing {
            @ParameterizedTest(name = "going {0} results in ({1},{2}) facing {3}")
            @CsvSource({
                "lf  ,0,1,WEST",
                "llf ,1,0,SOUTH",
                "lllf,2,1,EAST",
                "rf  ,2,1,EAST",

                "lb  ,2,1,WEST",
                "llb ,1,2,SOUTH",
                "lllb,0,1,EAST",

                "rfrfrfrf,1,1,NORTH",

                "'',1,1,NORTH"
            })
            void can_move(String where, int expectedX, int expectedY, Direction expectedDirection) {
                var rover = new MarsRover();

                rover.go(where);

                assertThat(rover.position()).isEqualTo(new Position(expectedX, expectedY));
                assertThat(rover.facing()).isEqualTo(expectedDirection);
            }
        }

    }

}
