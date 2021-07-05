import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Write a function that returns a String for a given number from 1 - 100.
 * For multiples of 3 print Fizz instead of the number
 * For the multiples of 5 print Buzz instead of the number
 * For numbers which are multiples of both 3 and 5 print FizzBuzz instead of
 * the number
 * <p>
 * e.g.:
 * 1
 * 2
 * Fizz
 * 4
 * Buzz
 * ...
 * 14
 * FizzBuzz
 */
public class FizzBuzzTest {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    private static Stream<Arguments> validFizzBuzzNumbers() {
        return Stream.of(
            Arguments.of(1, "1"),
            Arguments.of(2, "2"),
            Arguments.of(3, "Fizz"),
            Arguments.of(9, "Fizz"),
            Arguments.of(5, "Buzz"),
            Arguments.of(10, "Buzz"),
            Arguments.of(15, "FizzBuzz"),
            Arguments.of(100, "Buzz")
        );
    }

    @ParameterizedTest(name = "fizzBuzz({0}) is {1}")
    @MethodSource("validFizzBuzzNumbers")
    void test_valid_fizz_buzz_numbers(int number, String expected) {
        String result = fizzBuzz(number);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "fizzBuzz({0}) is not a valid input")
    @ValueSource(ints = {0, -1, 101, 102})
    void test_illegal_numbers(int number) {
        assertThatThrownBy(() -> fizzBuzz(number))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private String fizzBuzz(int number) {
        assertValidNumber(number);

        if (isFizz(number) && isBuzz(number)) {
            return FIZZ + BUZZ;
        } else if (isFizz(number)) {
            return FIZZ;
        } else if (isBuzz(number)) {
            return BUZZ;
        }
        return String.valueOf(number);
    }

    private void assertValidNumber(int number) {
        if (number <= 0 || number >= 101) throw new IllegalArgumentException();
    }

    private boolean isFizz(int number) {
        return number % 3 == 0;
    }

    private boolean isBuzz(int number) {
        return number % 5 == 0;
    }
}

