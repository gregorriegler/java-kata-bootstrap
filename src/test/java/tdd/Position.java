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

    Position invert() {
        return new Position(x * -1, y * -1);
    }

    Position add(Position facing, int worldSize) {
        int newX = wrapAround(x, worldSize, facing.x);
        int newY = wrapAround(y, worldSize, facing.y);
        return new Position(newX, newY);
    }

    private int wrapAround(int y, int worldSize, int vector) {
        return y == worldSize * vector ?
            worldSize * -vector : y + vector;
    }
}
