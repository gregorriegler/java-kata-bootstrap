package tdd;

class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position invert() {
        return new Position(-x, -y);
    }

    public Position add(Position vector, World world) {
        return new Position(
            xOutOfBounds(vector, world.size) ? wrapAround(vector.x, world.size) : x + vector.x,
            yOutOfBounds(vector, world.size) ? wrapAround(vector.y, world.size) : y + vector.y
        );
    }

    private int wrapAround(int coordinate, int worldSize) {
        return worldSize * coordinate * -1;
    }

    private boolean yOutOfBounds(Position vector, int worldSize) {
        return Math.abs(y + vector.y) > worldSize;
    }

    private boolean xOutOfBounds(Position vector, int worldSize) {
        return Math.abs(x + vector.x) > worldSize;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}
