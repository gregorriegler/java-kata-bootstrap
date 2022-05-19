import org.junit.jupiter.api.Test;

import java.time.Instant;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

public class TickerTest {

    @Test
    void ticks_one_time_after_a_minute() {
        TickableSpy tickable = new TickableSpy();
        FakeClock clock = new FakeClock(Instant.MIN);
        Ticker ticker = new Ticker(clock, tickable);
        ticker.start();

        clock.setTime(Instant.MIN.plusSeconds(60));

        await().atMost(500, MILLISECONDS)
            .untilAsserted(() -> assertThat(tickable.ticked()).isEqualTo(1));
    }

    @Test
    void doesnt_tick_after_less_than_a_minute() throws InterruptedException {
        TickableSpy tickable = new TickableSpy();
        FakeClock clock = new FakeClock(Instant.MIN);
        Ticker ticker = new Ticker(clock, tickable);
        ticker.start();

        clock.setTime(Instant.MIN.plusSeconds(59));

        Thread.sleep(150);
        assertThat(tickable.ticked()).isEqualTo(0);
    }

}

