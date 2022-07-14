package tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloWorldTest {

    @Test
    void hello() {
        var hello = "hello";

        assertThat(hello).isEqualTo("world");
    }
}
