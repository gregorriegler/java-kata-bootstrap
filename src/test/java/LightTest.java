import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LightTest {

    @Test
    void can_turn_on_giving_millis() {
        Light light = new Light(LightStatus.OFF);

        light.turnOnForMillis(1);

        assertThat(light.getStatus()).isEqualTo(LightStatus.ON);
    }
}
