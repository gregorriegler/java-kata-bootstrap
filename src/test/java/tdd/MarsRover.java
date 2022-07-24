package tdd;

class MarsRover {

    private Position position = new Position(0, 0);
    private Direction facing = Direction.NORTH;

    public void sendCommands(String commands) {
        for (char command : commands.toCharArray()) {
            if (command == 'r') {
                facing = facing.right();
            } else if (command == 'l') {
                facing = facing.left();
            } else if (command == 'f') {
                position = forward();
            } else if (command == 'b') {
                position = backwards();
            }
        }
    }

    private Position backwards() {
        Position vector = facing.vector.invert();
        return position.move(vector.x, vector.y);
    }

    private Position forward() {
        return position.move(facing.vector.x, facing.vector.y);
    }

    public Direction facing() {
        return facing;
    }

    public Position position() {
        return position;
    }
}
