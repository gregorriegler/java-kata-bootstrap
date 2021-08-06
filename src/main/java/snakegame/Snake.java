package snakegame;

public class Snake {

    private Direction direction;
    private int length;

    public Snake() {
        this.headX = 0;
        this.headY = 0;
        this.direction = Direction.EAST;
        this.length = 1;
    }

    private int headX, headY;

    public Direction getDirection() {
        return this.direction;
    }

    public int getHeadX() {
        return this.headX;
    }

    public int getHeadY() {
        return this.headY;
    }

    public void move() {
        if (Direction.SOUTH == this.direction) {
            ++headY;
        } else {
            ++headX;
        }
    }

    public void turnSouth() {
        this.direction = Direction.SOUTH;
    }

    public int getLength() {
        return this.length;
    }

    public enum Direction{
        EAST,
        SOUTH
    }

}
