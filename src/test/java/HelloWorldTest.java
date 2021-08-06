import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HelloWorldTest {

    @Test
    void hello() {
        var hello = "hello";

        assertThat(hello).isEqualTo("hello");
    }

    @Test
    void world_exists() {
        World world = new World();

        assertThat(world.getGrid()).isNotNull();
    }

    private class World {
        public void getGrid() {

        }
    }
}

interface Game {
    void world();
}


