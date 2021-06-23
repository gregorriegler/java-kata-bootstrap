import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Write a program that prints the numbers from 1 to 100.
 * But for multiples of 3 print “Fizz”.
 * And for the multiples of 5 print “Buzz”.
 * For multiples of both 3 and 5 print “FizzBuzz”.
 * 1, 2, Fizz, 4, Buzz, . . . 14, FizzBuzz, 16
 */
public class FizzBuzzTest {

    // Implementation
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZ_BUZZ = "FizzBuzz";

    private static Stream<Arguments> fizzBuzzExpectations() {
        return Stream.of(
            Arguments.of(1, "1"),
            Arguments.of(2, "2"),
            Arguments.of(3, "Fizz"),
            Arguments.of(4, "4"),
            Arguments.of(5, "Buzz"),
            Arguments.of(15, "FizzBuzz")
        );
    }

    @ParameterizedTest(name = "fizzBuzz of {0} is {1}")
    @MethodSource("fizzBuzzExpectations")
    void testValidNumbers(int number, String expected) {
        assertThat(fizzBuzz(number)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0} is an invalid number")
    @ValueSource(ints = {0, -1, 101})
    void testInvalidNumbers(int number) {
        assertThatThrownBy(() -> fizzBuzz(number))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(number + " is not a valid input");
    }

    private String fizzBuzz(int number) {
        if (isInvalid(number)) throw new IllegalArgumentException(number + " is not a valid input");
        if (isFizzBuzz(number)) return FIZZ_BUZZ;
        if (isFizz(number)) return FIZZ;
        if (isBuzz(number)) return BUZZ;
        return String.valueOf(number);
    }

    private boolean isInvalid(int number) {
        return number <= 0 || number >= 101;
    }

    private boolean isFizzBuzz(int number) {
        return isFizz(number) && isBuzz(number);
    }

    private boolean isFizz(int number) {
        return number % 3 == 0;
    }

    private boolean isBuzz(int number) {
        return number % 5 == 0;
    }
}