import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

public class TickerTest {

    @Test
    void ticks_one_time_after_a_minute() {
        TickableSpy tickable = new TickableSpy();
        FakeClock clock = new FakeClock(Instant.MIN);
        Ticker ticker = new Ticker(clock, tickable);
        ticker.start();

        clock.setTime(Instant.MIN.plusSeconds(60));

        assertThat(tickable.ticked()).isEqualTo(1);
    }

    @Disabled
    @Test
    void doesnt_tick_after_less_than_a_minute() {
        TickableSpy tickable = new TickableSpy();
        FakeClock clock = new FakeClock(Instant.MIN);
        Ticker ticker = new Ticker(clock, tickable);
        ticker.start();

        clock.setTime(Instant.MIN.plusSeconds(59));

        assertThat(tickable.ticked()).isEqualTo(0);
    }

}

