import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

class Ticker {

    private int ticks = 0;
    private Clock clock;
    private TickableSpy tickable;

    public Ticker(Clock clock, TickableSpy tickable) {
        this.clock = clock;
        this.tickable = tickable;
    }

    public void start() {
        Instant oldTime = clock.instant();
        while (ticks == 0) {
            Instant newTime = clock.instant();

            Duration duration = Duration.ofMinutes(1);
            if (duration.getSeconds() >= 60) {
                ticks = 1;
                tickable.tick();
            }
            oldTime = newTime;
        }
    }


}
