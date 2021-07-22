import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciTest {

    @ParameterizedTest
    @CsvSource({
        "0,1",
        "1,1"
    })
    void test(int index, int expected) {
        assertThat(fibonacci(index))
            .isEqualTo(expected);
    }

    private int fibonacci(int index) {
        return 1;
    }
}
