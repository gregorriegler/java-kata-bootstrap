import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HelloWorldTest {

    @Test
    void hello() {
        var hello = "hello";

        assertThat(hello).isEqualTo("hello");

        Hello helloMock = mock(Hello.class);
        helloMock.world();
        verify(helloMock).world();
    }
}

interface Hello {
    void world();
}
