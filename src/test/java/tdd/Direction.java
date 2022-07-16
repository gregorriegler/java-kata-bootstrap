package tdd;

enum Direction {
    N("W", new Position(0, 1), "E"),
    E("N", new Position(1, 0), "S"),
    S("E", new Position(0, -1), "W"),
    W("S", new Position(-1, 0), "N");

    public final Position vector;
    private final String left;
    private final String right;

    Direction(String left, Position vector, String right) {
        this.left = left;
        this.right = right;
        this.vector = vector;
    }

    public Direction right() {
        return Direction.valueOf(right);
    }

    public Direction left() {
        return Direction.valueOf(left);
    }
}
