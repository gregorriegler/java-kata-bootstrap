package snakegame;

public class World {

    private final Size size;

    public World(Size size) {
        this.size = size;
    }

    public Snake getSnake() {
        return new Snake();
    }

    public Apple getApple() {
        return new Apple();
    }

    public Size getSize() {
        return this.size;
    }
}
