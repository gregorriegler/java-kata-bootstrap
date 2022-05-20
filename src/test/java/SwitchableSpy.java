public class SwitchableSpy implements Switchable {

    public String status = "off";

    @Override
    public void turnOn() {
        status = "on";
    }

    @Override
    public void turnOff() {
        status = "off";
    }
}
