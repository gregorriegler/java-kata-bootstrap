class HomeSecuritySystem {

    private final OnForMillis light;

    public HomeSecuritySystem(OnForMillis light) {
        this.light = light;
    }

    public void onMotion() {
        light.turnOnForMillis(1000 * 60 * 5);
    }
}
