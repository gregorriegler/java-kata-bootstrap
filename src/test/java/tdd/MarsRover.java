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
        return position.move(0, 1);
    }

    private Position forward() {
        if(facing == Direction.EAST) {
            return position.moveByVector(facing.vector);
        }
        if(facing == Direction.SOUTH) {
            return position.moveByVector(facing.vector);
        }
        if(facing == Direction.WEST) {
            return position.moveByVector(facing.vector);
        }
        return position.move(0, -1);
    }

    public Direction facing() {
        return facing;
    }

    public Position position() {
        return position;
    }
}
