import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Write a function that takes a number between 1 and 100.
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
