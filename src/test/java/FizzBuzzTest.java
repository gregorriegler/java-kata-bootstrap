import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Participants:
 * Fabian Wimmer (Red)
 * Edin Emrula (Red)
 * Maximilian Rosenberger (Green)
 * Katharina Jurschitz (Green)
 * Peter Frimberger (Refactor)
 * Tijana Maksimovic (Refactor)
 * Andreas Träxler (Navigator)
 * Felix Macho (Navigator)
 * Oleh Baidiuk (Navigator)
 * Luuk de Waal Malefijt (Predictor)
 * Mohamed Dalash (Predictor)
 * Hadi Kazemi (Predictor)
 * <p>
 * Roles:
 * Red Referee: This role is responsible to make sure we watch each test fail
 * and that the error presented is useful and expressive.
 * Green Referee: Watches out that we only write the simplest code to fulfill
 * the test, but not the line of code we know we’d need to write.
 * Refactor Referee: Makes sure we always refactor in the green and only in
 * the green.
 * Navigator: Decides on the next step and decides which code to write.
 * Predictor: Predicts what the outcome of the next Test run will be.
 * <p>
 * Task:
 * Write a program that takes a number between 1 and 100.
 * It should print the number,
 * but for multiples of 3 print “Fizz”.
 * And for the multiples of 5 print “Buzz”.
 * For multiples of both 3 and 5 print “FizzBuzz”.
 * 1, 2, Fizz, 4, Buzz, ..., 14, FizzBuzz, 16
 */

public class FizzBuzzTest {

    @ParameterizedTest
    @CsvSource({
        "0,Out of Range",
        "1,1",
        "2,2",
        "3,Fizz",
        "9,Fizz",
        "10,Buzz",
        "15,FizzBuzz",
        "100,Buzz",
        "101,Out of Range"
    })
    void testFizzBuzz(int input, String expected) {
        String actual = fizzBuzz(input);
        assertThat(actual).isEqualTo(expected);
    }

    private String fizzBuzz(int input) {
        if (input <= 0 || input >= 101) return "Out of Range";
        if (input % 15 == 0) return "FizzBuzz";
        if (input % 3 == 0) return "Fizz";
        if (input % 5 == 0) return "Buzz";
        return String.valueOf(input);
    }
}
