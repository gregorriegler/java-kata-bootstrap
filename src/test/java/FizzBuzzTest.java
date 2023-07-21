import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    @Test
    void shouldFizzBuzz() {
        var fizzBuzz = new FizzBuzz();
        var actual = fizzBuzz.run();

        assertThat(actual).isEqualTo(
            "1-2-Fizz-4-Buzz-Fizz-7-8-Fizz-Buzz-11-Fizz-13-14-Fizz-16-17-Fizz-19-Buzz-"
        );
    }
}

