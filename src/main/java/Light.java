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
