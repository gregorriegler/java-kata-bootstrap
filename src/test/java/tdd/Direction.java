package tdd;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST,
    ;

    Direction right() {
        if(this.ordinal() == Direction.values().length-1) {
            return Direction.values()[0];
        }
        int i = this.ordinal() + 1;
        return Direction.values()[i];
    }
}
