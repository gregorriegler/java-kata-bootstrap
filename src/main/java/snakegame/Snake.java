package snakegame;

public class Snake {

    private Direction direction;

    public Snake() {
        this.headX = 0;
        this.headY = 0;
        this.direction = Direction.EAST;
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

    public enum Direction{
        EAST,
        SOUTH
    }

}
