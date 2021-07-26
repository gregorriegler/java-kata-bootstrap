import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// 0  1  2  3  4  5 (index)
// 1, 1, 2, 3, 5, 8 (fibonacci)
public class FibonacciTest {

    @CsvSource({
        "0,1",
        "1,1",
        "2,2",
        "3,3",
        "4,5",
        "5,8"
    })
    @ParameterizedTest(name = "fibonacci of {0} is {1}")
    void test_fibonacci(int index, int expected) {
        int result = fibonacci(index);

        assertThat(result).isEqualTo(expected);
    }

    private int fibonacci(int index) {
        if(index > 1) {
            return fibonacci(index-1) + fibonacci(index - 2);
        }
        return 1;
    }
}
