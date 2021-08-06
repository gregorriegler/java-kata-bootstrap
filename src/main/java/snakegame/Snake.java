package snakegame;

public class Snake {

    public Snake() {
        this.headX = 0;
        this.headY = 0;
    }

    private int headX, headY;

    public int getHeadX() {
        return this.headX;
    }

    public int getHeadY() {
        return this.headY;
    }

    public void move() {
        ++headX;
    }

    enum Direction{

    }

}
