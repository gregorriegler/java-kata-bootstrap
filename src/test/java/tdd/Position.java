package tdd;

import java.util.Objects;

public class Position {
    public final int y;
    public final int x;

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
        int newY = wrapAround(y, worldSize, yVector);
        int newX = wrapAround(x, worldSize, xVector);
        return new Position(newX, newY);
    }

    private int wrapAround(int y, int worldSize, int vector) {
        return y == worldSize * vector ?
            worldSize * -vector : y + vector;
    }

    Position moveByVector(Position vector) {
        return move(vector.x, vector.y);
    }
}
