package tdd;

public class MarsRover {

    private final World world = new World();
    private Direction facing = Direction.N;
    private Position position = new Position(0, 0);

    public String at() {
        return direction() + "," + position();
    }

    private String position() {
        return position.toString();
    }

    private String direction() {
        return facing.toString();
    }

    public void go(String commands) {
        for (char command : commands.toCharArray()) {
            command(command);
        }
    }

    private void command(char command) {
        switch (command) {
            case 'r':
                turnRight();
                break;
            case 'l':
                turnLeft();
                break;
            case 'f':
                forward();
                break;
            case 'b':
                backward();
                break;
            default: throw new IllegalArgumentException();
        }
    }

    private void forward() {
        position = position.add(facing.vector, world);
    }

    private void backward() {
        position = position.add(facing.vector.invert(), world);

    }

    private void turnLeft() {
        facing = facing.left();
    }

    private void turnRight() {
        facing = facing.right();
    }
}