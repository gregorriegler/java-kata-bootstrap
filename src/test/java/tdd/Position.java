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
        int i = 2;
        int newY = y == i * yVector ? i * -yVector : y + yVector;
        int newX = x == i * xVector ? i * -xVector : x + xVector;
        return new Position(newX, newY);
    }
}
