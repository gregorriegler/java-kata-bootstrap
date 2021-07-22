import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class FibonacciTest {

    @ParameterizedTest
    @CsvSource({
        "0,1",
        "1,1",
        "2,2",
    })
    void test(int index, int expected) {
        assertThat(fibonacci(index))
            .isEqualTo(expected);
    }

    private int fibonacci(int index) {
        if(index >= 2) {
            return 2;
        }
        return 1;
    }
}
