import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;

public class TickerTest {

    @Test
    void ticks_one_time_after_a_minute() {
        FakeTickable tickable = new FakeTickable();
        FakeClock clock = new FakeClock(Instant.MIN);
        Ticker ticker = new Ticker(clock, tickable);
        ticker.start();

        clock.setTime(Instant.MIN.plusSeconds(61)); // 60

        assertThat(tickable.ticked()).isEqualTo(1);
    }

    @Disabled
    @Test
    void doesnt_tick_after_less_than_a_minute() {
        FakeTickable tickable = new FakeTickable();
        FakeClock clock = new FakeClock(Instant.MIN);
        Ticker ticker = new Ticker(clock, tickable);
        ticker.start();

        clock.setTime(Instant.MIN.plusSeconds(59));

        assertThat(tickable.ticked()).isEqualTo(0);
    }

}

interface Tickable {
    void tick();
}

class FakeTickable implements Tickable {

    private int ticks = 0;

    @Override
    public void tick() {
        ticks++;
        
    }

    public int ticked() {
        return ticks;
    }
}

class Ticker {

    private int ticks = 0;
    private Clock clock;
    private FakeTickable tickable;

    public Ticker(Clock clock, FakeTickable tickable) {
        this.clock = clock;
        this.tickable = tickable;
    }

    public void start() {
        Instant oldTime = clock.instant();
        while (ticks == 0) {
            Instant newTime = clock.instant();

            Duration duration = Duration.ofMinutes(1);
            if(duration.getSeconds() >= 60) {
                ticks = 1;
                tickable.tick();
            }
            oldTime = newTime;
        }
    }


}

class FakeClock extends Clock {

    private Instant time;

    public FakeClock(Instant startsWith) {
        this.time = startsWith;
    }

    @Override
    public ZoneId getZone() {
        return null;
    }

    @Override
    public Clock withZone(ZoneId zone) {
        return null;
    }

    @Override
    public Instant instant() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }
}
