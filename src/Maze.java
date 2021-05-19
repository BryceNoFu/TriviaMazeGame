import Point;
public class Maze {

    private Room[][] rooms;
    private Point currentPosition;

    public Maze(int width, int height) {
        this.rooms = new Room[height][width];
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                this.rooms[i][j] = new Room();
            }
        }
    }

    public void goUp() {
        currentPosition.setY(currentPosition.getY()-1);
    }

    public void goDown() {
        currentPosition.setY(currentPosition.getY()+1);
    }

    public void goLeft() {
        currentPosition.setX(currentPosition.getX()-1);
    }

    public void goRight() {
        currentPosition.setX(currentPosition.getX()+1);
    }
}
