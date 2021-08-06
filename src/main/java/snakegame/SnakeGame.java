package snakegame;

public class SnakeGame implements Game {

    private World world;

    public SnakeGame(Size size) {
        this.world = new World(size);
    }

    @Override
    public World world() {
        return this.world;
    }
}
