import java.util.TimerTask;

class Timer {
    private final Switchable switchable;

    public Timer(Switchable switchable) {
        this.switchable = switchable;
    }

    public void turnOnForMillis(long millis) {
        switchable.turnOn();
        new java.util.Timer().schedule(turnOffTask(), millis);
    }

    private TimerTask turnOffTask() {
        return new TimerTask() {
            @Override
            public void run() {
                switchable.turnOff();
            }
        };
    }
}
