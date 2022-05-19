class TickableSpy implements Tickable {

    private int ticks = 0;

    @Override
    public void tick() {
        ticks++;

    }

    public int ticked() {
        return ticks;
    }
}
