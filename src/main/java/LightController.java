class LightController {

    private final Switchable light;

    public LightController(Switchable light) {
        this.light = light;
    }

    public void onMotion() {
        light.turnOnForMillis(1000 * 60 * 5);
    }
}
