class HomeSecuritySystem {

    private final Timer light;

    public HomeSecuritySystem(Timer light) {
        this.light = light;
    }

    public void onMotion() {
        light.turnOnForMillis(1000 * 60 * 5);
    }
}
