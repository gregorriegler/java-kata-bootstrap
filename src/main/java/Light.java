import java.util.Timer;
import java.util.TimerTask;

class Light {
    LightStatus status;

    public Light(LightStatus status) {
        this.status = status;
    }

    public LightStatus getStatus() {
        return status;
    }

    void turnOn() {
        status = LightStatus.ON;
    }

    public void turnOff() {
        status = LightStatus.OFF;
    }

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
