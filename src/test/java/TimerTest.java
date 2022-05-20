import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

public class TimerTest {

    @Test
    void can_turn_on_for_millis() {
        SwitchableSpy switchable = new SwitchableSpy();
        Timer timer = new Timer(switchable);

        timer.turnOnForMillis(1);

        assertThat(switchable.status).isEqualTo("on");
    }

    @Test
    void turns_off_after_given_millis() {
        SwitchableSpy switchable = new SwitchableSpy();
        Timer timer = new Timer(switchable);

        timer.turnOnForMillis(1);

        await().atMost(Duration.ofMillis(500))
            .untilAsserted(() -> assertThat(switchable.status).isEqualTo("off"));
    }
}
