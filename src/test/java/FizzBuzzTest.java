import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
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
 * Participants:
 * <p>
 * Roles:
 * ## Navigator
 * Janos Hackl
 * Mehran Hosseini
 * <p>
 * ## Predictor
 * Alexander Feiertag
 * Georg Dollmann
 * <p>
 * ## Red Referee
 * Timot Budavari
 * Maria Edlinger
 * <p>
 * ## Green Referee
 * Felix Macho
 * Mehmet Ali Akalin
 * <p>
 * ## Refactor Referee
 * Seimi Terasaki
 * Sergej Strajnak
 * <p>
 * =============================================================================
 * <p>
 * Write a program that takes a number between 1 and 100.
 * It should print the number,
 * but for multiples of 3 print “Fizz”.
 * And for the multiples of 5 print “Buzz”.
 * For multiples of both 3 and 5 print “FizzBuzz”.
 * Example: "1", "2", "Fizz", "4", "Buzz", ..., "14", "FizzBuzz", "16"
 */
public class FizzBuzzTest {

    @ParameterizedTest
    @CsvSource({
        "1,1",
        "2,2"
    })
    void ordinary_numbers_yield_number_as_string(int number, String expectededString) {
        assertThat(toFizzBuzzString(number)).isEqualTo(expectededString);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9})
    void multiple_of_3_yields_Fizz(int number) {
        assertThat(toFizzBuzzString(number)).isEqualTo("Fizz");
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10})
    void multiple_of_5_yields_Buzz(int number) {
        assertThat(toFizzBuzzString(number)).isEqualTo("Buzz");
    }

    private String toFizzBuzzString(int number) {
        if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return "" + number;
        }
    }
}
