import org.junit.jupiter.api.Test;

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
 *
 * Participants:
 * Alexander Feiertag
 * Georg Dollmann
 * Mehran Hosseini
 * Maria Edlinger
 * Mehmet Ali Akalin
 * Seimi Terasaki
 * Felix Macho
 * Janos Hackl
 * Sergej Strajnak
 * Timot Budavari
 *
 * Roles:
 * ## Navigator
 *
 * ## Predictor
 *
 * ## Red Referee
 *
 * ## Green Referee
 *
 * ## Refactor Referee
 *
 * =============================================================================
 *
 * Write a program that takes a number between 1 and 100.
 * It should print the number,
 * but for multiples of 3 print “Fizz”.
 * And for the multiples of 5 print “Buzz”.
 * For multiples of both 3 and 5 print “FizzBuzz”.
 * 1, 2, Fizz, 4, Buzz, ..., 14, FizzBuzz, 16
 */
public class FizzBuzzTest {

    @Test
    void hello() {
        var hello = "hello";

        assertThat(hello).isEqualTo("hello");
    }
}
