package tdd;

class MarsRover {

    private Position position = new Position(0, 0);
    private Direction facing = Direction.NORTH;

    public void sendCommands(String commands) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'r':
                    facing = facing.right();
                    break;
                case 'l':
                    facing = facing.left();
                    break;
                case 'f':
                    position = forward();
                    break;
                case 'b':
                    position = backwards();
                    break;
                default:
            }
        }
    }

    private Position forward() {
        return position.move(facing.vector.x, facing.vector.y);
    }

    private Position backwards() {
        Position vector = facing.vector.invert();
        return position.move(vector.x, vector.y);
    }

    public Direction facing() {
        return facing;
    }

    public Position position() {
        return position;
    }
}
