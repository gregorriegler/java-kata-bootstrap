public class TimerSpy extends Timer {

    public String recentCommand;

    public TimerSpy() {
        super(null);
    }

    @Override
    public void turnOnForMillis(long millis) {
        recentCommand = "turn on for " + millis + "ms";
    }
}
