import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FizzBuzzTest {

    @Test
    void shouldFizzBuzz() {
        var fizzBuzz = new FizzBuzz();
        var actual = fizzBuzz.run();

        assertThat(actual).isEqualTo("1");
    }
}

