package tdd;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST,
    ;

    Direction right() {
        return Direction.values()[this.ordinal()+1];
    }
}
