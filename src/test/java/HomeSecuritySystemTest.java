import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


enum LightStatus {
    ON, OFF;
}

/**
 * Version 1:
 * motion detected -> turn on light for 5min
 * after light turned on for 5 min -> light turns off
 * no motion -> nothing happens
 * <p>
 * Version 2:
 * WinterMonths / SummerMonths
 * WinterMonths have letter "r" in the name
 * WinterMonths have daylight from 8am to 6pm
 * SummerMonths have daylight from 6am to 8pm
 *
 * whichTimeIsIt(time) => Day/Night
 *
 * winterOrSummer(time) => Winter/Summer
 *
 * Given I have a daytime calculator
 * And its January 1st 8am
 *
 * When I ask it what time it is
 *
 * Then it will yield DayTime
 */
public class HomeSecuritySystemTest {

    @Test
    void turns_on_light_when_motion_detected() {
        Light light = new Light(LightStatus.OFF);
        HomeSecuritySystem system = new HomeSecuritySystem(light);

        system.onMotionDetected();

        assertThat(light.getStatus()).isEqualTo(LightStatus.ON);
    }

    @Test
    void light_turns_off_after_5min() {
        Light light = new Light(LightStatus.ON);
        HomeSecuritySystem system = new HomeSecuritySystem(light);

        system.tick();
        system.tick();
        system.tick();
        system.tick();
        system.tick();

        assertThat(light.getStatus()).isEqualTo(LightStatus.OFF);
    }

    @Test
    void light_stays_off_after_5min() {
        Light light = new Light(LightStatus.OFF);
        HomeSecuritySystem system = new HomeSecuritySystem(light);

        system.tick();
        system.tick();
        system.tick();
        system.tick();
        system.tick();

        assertThat(light.getStatus()).isEqualTo(LightStatus.OFF);
    }

    @Test
    void light_turns_off_after_5min_() {
        Light light = new Light(LightStatus.ON);
        HomeSecuritySystem system = new HomeSecuritySystem(light);
        lightGotTurnedOffAfter5Min(light, system);

        light.turnOn();

        assertTurnsOffAfterAnother5Minutes(light, system);
    }

    private void lightGotTurnedOffAfter5Min(Light light, HomeSecuritySystem system) {
        system.tick();
        system.tick();
        system.tick();
        system.tick();
        system.tick();

        assertThat(light.getStatus()).isEqualTo(LightStatus.OFF);
    }

    private void assertTurnsOffAfterAnother5Minutes(Light light, HomeSecuritySystem system) {
        system.tick();
        assertThat(light.getStatus()).isEqualTo(LightStatus.ON);
        system.tick();
        system.tick();
        system.tick();
        assertThat(light.getStatus()).isEqualTo(LightStatus.ON);
        system.tick();
        assertThat(light.getStatus()).isEqualTo(LightStatus.OFF);
    }
}

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
        if (status == LightStatus.OFF) return;
        status = LightStatus.OFF;
    }
}

class HomeSecuritySystem implements Tickable {

    private final Light light;
    private long ticks = 0;

    public HomeSecuritySystem(Light light) {
        this.light = light;
    }

    public void onMotionDetected() {
        light.turnOn();
    }

    @Override
    public void tick() {
        ticks++;
        if (ticks >= 5) {
            ticks = 0;
            light.turnOff();
        }
    }
}