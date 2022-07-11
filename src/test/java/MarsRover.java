class MarsRover {

    private Direction facing = Direction.NORTH;
    private Position position = new Position(1, 1);

    public Position position() {
        return position;
    }

    public Direction facing() {
        return facing;
    }

    public void go(String commands) {
        if ("".equals(commands)) return;

        for (char singleCommand : commands.toCharArray()) {
            move(singleCommand);
        }
    }

    private void move(char command) {
        switch (command) {
            case 'f':
                forward();
                break;
            case 'r':
                turnRight();
                break;
            case 'l':
                turnLeft();
                break;
            case 'b':
                backward();
                break;
            default:
                throw new IllegalArgumentException("illegal command");
        }
    }

    private void turnLeft() {
        facing = facing.left();
        what();
    }

    private void what() {
        
    }


    private void turnRight() {
        facing = facing.right();
    }

    private void forward() {
        position = position.forward(facing);
    }

    private void backward() {
        position = position.backward(facing);
    }

}
