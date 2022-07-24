package tdd;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST,
    ;

    private final Position position;

    Direction() {
        position = new Position(1, 0);
    }

    Direction right() {
        int index = atRightest() ? 0 : this.ordinal() + 1;
        return Direction.values()[index];
    }

    Direction left() {
        int index = atLeftest() ? Direction.values().length - 1 : this.ordinal() - 1;
        return Direction.values()[index];
    }

    private boolean atRightest() {
        return this.ordinal() == Direction.values().length - 1;
    }

    private boolean atLeftest() {
        return this.ordinal() == 0;
    }

    Position getVector() {
        return position;
    }
}
