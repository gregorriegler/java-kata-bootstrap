package tdd;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST,
    ;

    Direction right() {
        if (this.ordinal() == Direction.values().length - 1) {
            return Direction.values()[0];
        }
        int index = this.ordinal() == Direction.values().length - 1 ? 0 : this.ordinal() + 1;
        return Direction.values()[index];
    }
}
