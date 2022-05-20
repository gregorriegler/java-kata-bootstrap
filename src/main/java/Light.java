import java.util.Timer;
import java.util.TimerTask;

class Light implements Switchable {
    LightStatus status;

    public Light(LightStatus status) {
        this.status = status;
    }

    public LightStatus getStatus() {
        return status;
    }

    private void turnOff() {
        status = LightStatus.OFF;
    }

    @Override
    public void turnOnForMillis(long millis) {
        status = LightStatus.ON;
        new Timer().schedule(turnOffTask(), millis);
    }

    private TimerTask turnOffTask() {
        return new TimerTask() {
            @Override
            public void run() {
                turnOff();
            }
        };
    }
}
