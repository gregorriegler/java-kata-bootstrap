package tdd;

import java.util.Collections;
import java.util.List;

class MarsRover {

    private final List<Position> world;
    private Position position = new Position(0, 0);
    private Direction facing = Direction.NORTH;

    public MarsRover() {
        this.world = List.of();
    }
    
    public MarsRover(List<Position> world) {
        this.world = world;
    }

    public void sendCommands(String commands) {
        for (char command : commands.toCharArray()) {
            executeCommand(command);
        }
    }

    private void executeCommand(char command) {
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
                throw new IllegalArgumentException("Illegal input");
        }
    }

    private Position forward() {
        return position.move(facing.vector, world);
    }

    private Position backwards() {
        Position vector = facing.vector.invert();
        return position.move(vector, world);
    }

    public Direction facing() {
        return facing;
    }

    public Position position() {
        return position;
    }

    public List<String> report() {
        return Collections.emptyList();
    }
}
