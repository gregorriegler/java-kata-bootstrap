import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

class Ticker {

    private final Clock clock;
    private final Tickable tickable;
    private boolean ticked = false;

    private Instant then;

    public Ticker(Clock clock, Tickable tickable) {
        this.clock = clock;
        this.tickable = tickable;
    }

    public void start() {
        then = clock.instant();
        new Thread(this::waitFor60SecondsThenTick).start();
    }

    private void waitFor60SecondsThenTick() {
        while (!ticked) {
            Instant now = clock.instant();
            Duration duration = Duration.between(then, now);
            if (duration.getSeconds() >= 60) {
                tick();
            }
            then = now;
        }
    }

    private void tick() {
        ticked = true;
        tickable.tick();
    }


}
