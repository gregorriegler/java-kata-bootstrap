package snakegame;

import java.applet.Applet;

public class World {

    public Snake getSnake() {
        return new Snake();
    }

    public Apple getApple() {
        return new Apple();
    }
}
