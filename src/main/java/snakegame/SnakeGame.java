package snakegame;

public class SnakeGame implements Game {

    @Override
    public World world() {
        return new World();
    }
}
