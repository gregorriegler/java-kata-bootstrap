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
        return Direction.values()[this.ordinal()+1];
    }
}
