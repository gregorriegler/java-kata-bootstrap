import java.util.Objects;

class Position {

    public final int y;
    private final int x;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Position forward(Direction facing) {
        return this.add(facing.forward());
    }

    private Position add(Position position) {
        return new Position(x + position.x, y + position.y);
    }

    Position backward(Direction facing) {
        return this.add(facing.backward());
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

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
