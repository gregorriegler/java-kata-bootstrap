package snakegame;

public class World {

    private Snake snake;
    private Apple apple;
    private final Size size;

    public World(Size size) {
        this.size = size;
    }

    public Snake getSnake() {
        return this.snake;
    }

    public Apple getApple() {
        return this.apple;
    }

    public Size getSize() {
        return this.size;
    }

    public void placeApple(int x, int y) {
        apple=new Apple(x,y);
    }

    public void moveSnake(){
        snake.move();
        if(snake.getHeadX()==apple.getX() && snake.getHeadY()==apple.getY()){
            snake.grow();
        }
    }
}
