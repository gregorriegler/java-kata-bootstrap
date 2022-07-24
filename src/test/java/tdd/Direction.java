package tdd;

public enum Direction {
    NORTH(new Position(1, 0)),
    EAST(new Position(1, 0)),
    SOUTH(new Position(1, 0)),
    WEST(new Position(1, 0)),
    ;

    private final Position position;

    Direction(Position position1) {
        position = position1;
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
