import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

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
