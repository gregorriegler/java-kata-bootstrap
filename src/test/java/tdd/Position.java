package tdd;

import java.util.Objects;

public class Position {
    private final int x;
    public final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    Position move(int xVector, int yVector) {
        int worldSize = 2;
        int newY = getNewY(yVector, worldSize);
        int newX = x == worldSize * xVector ? worldSize * -xVector : x + xVector;
        return new Position(newX, newY);
    }

    private int getNewY(int yVector, int worldSize) {
        return y == worldSize * yVector ? worldSize * -yVector : y + yVector;
    }
}
