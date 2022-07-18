package tdd;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST,
    ;

    Direction right() {
        int index = atRightest() ? 0 : this.ordinal() + 1;
        return Direction.values()[index];
    }

    public Direction left() {
        int index = atLeftest() ? Direction.values().length - 1 : this.ordinal() - 1;
        return Direction.values()[index];
    }

    private boolean atRightest() {
        return this.ordinal() == Direction.values().length - 1;
    }
    
    private boolean atLeftest() {
        return this.ordinal() == 0;
    }
}
