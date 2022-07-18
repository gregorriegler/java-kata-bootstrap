package tdd;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST,
    ;

    Direction right() {
        int index = atEnd() 
            ? 0 
            : this.ordinal() + 1;
        return Direction.values()[index];
    }

    private boolean atEnd() {
        return this.ordinal() == Direction.values().length - 1;
    }
}
