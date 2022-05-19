class LightController implements Tickable {

    private final Light light;
    private long ticks = 0;

    public LightController(Light light) {
        this.light = light;
    }

    public void onMotion() {
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
