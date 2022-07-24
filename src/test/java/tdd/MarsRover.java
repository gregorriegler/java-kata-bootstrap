package tdd;

import java.util.ArrayList;
import java.util.List;

class MarsRover {

    private final List<Position> world;
    private final List<String> report = new ArrayList<>();
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
        return move(facing.vector);
    }

    private Position backwards() {
        Position vector = facing.vector.invert();
        return move(vector);
    }

    private Position move(Position vector) {
        Position newPosition = position.move(vector);
        if(world.contains(newPosition)) {
            report.add("Obstacle at " + newPosition);
            return position;
        }
        return newPosition;
    }

    public Direction facing() {
        return facing;
    }

    public Position position() {
        return position;
    }

    public List<String> report() {
        return report;
    }
}
