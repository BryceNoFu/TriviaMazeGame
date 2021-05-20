package maze;
import java.util.ArrayList;
import java.util.Random;

public class Maze {

    private Room[][] rooms;
    private int width;
    private int height;
    private Point currentPosition;
    private int hints;
    private Random random;

    public Maze(int width, int height, int hints) {
        this.rooms = new Room[height][width];
        this.hints = hints;
        this.width = width;
        this.height = height;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.rooms[i][j] = new Room();
            }
        }
    }

    public void setHints(int hints) {
        this.hints = hints;
    }

    public int getHints() {
        return this.hints;
    }

//    public void setRooms(ArrayList<Question> questionList) {
//
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                int index = random.nextInt(width-1);
//                this.rooms[i][j].setQuestion(questionList.remove(index));
//            }
//        }
//    }

    public void increaseHint()
    {
        this.hints++;
    }

    public void decreaseHint()
    {
        this.hints--;
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

    public String toString() {
        return "Maze by " + width + "x" + height;
    }
}
