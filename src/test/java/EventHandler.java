public interface EventHandler {
    void handle(LifeStateEvent event);
    void handle(NewGenerationEvent event);
}
