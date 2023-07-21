import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    @Test
    void shouldFizzBuzz() {
        var fizzBuzz = new FizzBuzz();
        var actual = fizzBuzz.run();

        assertThat(actual).isEqualTo(
            "1-2-3-4-5-6-7-8-9-10-11-12-13-14-15-16-17-18-19-20-"
        );
    }
}

