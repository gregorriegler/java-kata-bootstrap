public class NewGenerationEvent implements Event {
    @Override
    public void dispatch(EventHandler handler) {
        handler.handle(this);
    }
}
