import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciTest {

    @ParameterizedTest
    @CsvSource({
        "0,1",
        "1,1",
        "2,2",
        "3,3",
    })
    void test(int index, int expected) {
        assertThat(fibonacci(index)).isEqualTo(expected);
    }

    private int fibonacci(int index) {
        if (index < 2) {
            return 1;
        } else {
            return fibonacci(index - 1) + fibonacci(index - 2);
        }
    }
}
