import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

public class LightTest {

    @Test
    void can_turn_on_giving_millis() {
        Light light = new Light(LightStatus.OFF);

        light.turnOnForMillis(1);

        assertThat(light.getStatus()).isEqualTo(LightStatus.ON);
    }

    @Test
    void turns_off_after_given_millis() {
        Light light = new Light(LightStatus.OFF);

        light.turnOnForMillis(1);

        await().atMost(Duration.ofMillis(500))
            .untilAsserted(() -> assertThat(light.getStatus()).isEqualTo(LightStatus.OFF));
    }
}
