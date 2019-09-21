class Cell implements EventHandler {
    private final Broadcaster broadcaster;
    private int livingNeighbors;

    public Cell(Broadcaster broadcaster, boolean isAlive) {
        this.broadcaster = broadcaster;
    }


    public void onEvent(Event event) {
        event.dispatch(this);
    }

    @Override
    public void handle(LifeStateEvent event) {
        livingNeighbors++;
    }

    @Override
    public void handle(NewGenerationEvent event) {
        boolean shouldBeAlive = livingNeighbors == 4;
        broadcaster.broadcast(new LifeStateEvent(shouldBeAlive));
    }
}
