enum Direction {
    NORTH {
        @Override
        public Direction right() {
            return EAST;
        }

        @Override
        public Direction left() {
            return WEST;
        }

        @Override
        public Position forward() {
            return new Position(0, 1);
        }

        @Override
        public Position backward() {
            return new Position(0, -1);
        }
    },
    EAST {
        @Override
        public Direction right() {
            return SOUTH;
        }

        @Override
        public Direction left() {
            return NORTH;
        }

        @Override
        public Position forward() {
            return new Position(1, 0);
        }

        @Override
        public Position backward() {
            return new Position(-1, 0);
        }
    },
    SOUTH {
        @Override
        public Direction right() {
            return WEST;
        }

        @Override
        public Direction left() {
            return EAST;
        }

        @Override
        public Position forward() {
            return new Position(0, -1);
        }

        @Override
        public Position backward() {
            return new Position(0, 1);
        }
    },
    WEST {
        @Override
        public Direction left() {
            return SOUTH;
        }

        @Override
        public Direction right() {
            return NORTH;
        }

        @Override
        public Position forward() {
            return new Position(-1, 0);
        }

        @Override
        public Position backward() {
            return new Position(1, 0);
        }
    };

    public abstract Direction right();

    public abstract Direction left();

    public abstract Position forward();

    public abstract Position backward();


}
