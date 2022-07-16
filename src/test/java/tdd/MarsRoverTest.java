package tdd;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MarsRoverTest {

    @Test
    void initializes() {
        var rover = new MarsRover();

        assertThat(rover.at()).isEqualTo("N,0,0");
    }
    
    @Nested
    class Rotates {
        @ParameterizedTest(name = "turning {0} ends up {1}")
        @CsvSource({
            "r,'E,0,0'",
            "rr,'S,0,0'",
            "rrr,'W,0,0'",
            "rrrr,'N,0,0'",
            "l,'W,0,0'",
            "ll,'S,0,0'",
            "lll,'E,0,0'",
            "llll,'N,0,0'",
        })
        void rotates(String commands, String expectedAt) {
            var rover = new MarsRover();

            rover.go(commands);

            assertThat(rover.at()).isEqualTo(expectedAt);
        }
    }
    
    @Nested
    class Moves {
        @ParameterizedTest(name = "moving {0} ends up {1}")
        @CsvSource({
            "f,'N,0,1'",
            "ff,'N,0,2'",
            "fff,'N,0,-2'",

            "b,'N,0,-1'",
            "bb,'N,0,-2'",
            "bbb,'N,0,2'",

            "rf,'E,1,0'",
            "rff,'E,2,0'",
            "rfff,'E,-2,0'",

            "rb,'E,-1,0'",
            "rbb,'E,-2,0'",
            "rbbb,'E,2,0'",

            "rrf,'S,0,-1'",
            "rrff,'S,0,-2'",
            "rrfff,'S,0,2'",

            "rrb,'S,0,1'",
            "rrbb,'S,0,2'",
            "rrbbb,'S,0,-2'",

            "lf,'W,-1,0'",
            "lff,'W,-2,0'",
            "lfff,'W,2,0'",

            "lb,'W,1,0'",
            "lbb,'W,2,0'",
            "lbbb,'W,-2,0'",
        })
        void moves(String commands, String expectedAt) {
            var rover = new MarsRover();

            rover.go(commands);

            assertThat(rover.at()).isEqualTo(expectedAt);
        }
    }
}
