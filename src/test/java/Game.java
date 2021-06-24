public class Game {
    private final int size;
    private Direction direction;
    private int head;

    public Game(int size, int initialPosition) {
        this.size = size;
        this.head = initialPosition;
    }

    public void setDirection(Direction right) {
        direction = right;
    }

    public void tick() {
        if (direction != null) {
            head = (head + direction.change) % size;
        }
    }

    public String toString() {
        String result = "";
        for (int field = 0; field < size; field++) {
            if (field == head) {
                result += "x";
            } else {
                result += "-";
            }
        }
        return result;
    }

    public enum Direction {
        RIGHT(1), LEFT(-1);

        private final int change;

        Direction(int change) {
            this.change = change;
        }
    }
}
