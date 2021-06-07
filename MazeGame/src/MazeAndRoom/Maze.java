package MazeAndRoom;

import Questions.Question;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Creates a Maze object containing nxn rooms.
 * @author Natalie Nguyen Hong
 * @version Spring 2021
 */
public class Maze {

    /** An array of rooms in the maze. */
    private Room[][] rooms;

    /** The width of the maze. */
    private int width;

    /** The height of the maze. */
    private int height;

    /** The current position of user in the maze. */
    private Point currentPosition;

    /** The number of hints of the maze. */
    private int hints;

    /** The random object. */
    private static Random random;

    /** The list of questions in the maze. */
    private List<Question> questionList;



    /**
     * Construct a maze object that takes width, height and number of hints.
     * @param width the width of maze
     * @param height the height of maze
     * @param hints the number of hints
     */
    public Maze(int width, int height, int hints)
    {
        this.random = new Random(42);
        this.currentPosition = null;
        this.rooms = new Room[height][width];
        this.questionList = new ArrayList<Question>();
        this.hints = hints;
        this.width = width;
        this.height = height;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                rooms[i][j] = new Room();
            }
        }
    }

    /**
     * Construct a maze object that takes width, height, number of hints
     * and current position.
     * @param width the width of maze
     * @param height the height of maze
     * @param hints the number of hints
     * @param position the position of current room
     */
    public Maze(int width, int height, int hints, Point position)
    {
        this.random = new Random(42);
        this.currentPosition = position;
        this.rooms = new Room[height][width];
        this.questionList = new ArrayList<Question>();
        this.hints = hints;
        this.width = width;
        this.height = height;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                rooms[i][j] = new Room();
            }
        }
    }

    public Maze() {

    }

    /**
     * Sets the width of the maze.
     * @param width the width of the maze
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Returns the width of maze.
     * @return the width of maze
     */
    public int getWidth() {
        return  this.width;
    }

    /**
     * Sets the height of the maze.
     * @param height the height of the maze
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Returns the height of maze.
     * @return the height of maze
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Return the room at current position.
     * @return The room at current position
     */
    public Room getRoom() {
        return this.rooms[this.currentPosition.getY()][this.currentPosition.getY()];
    }

    /**
     * Return the current position.
     * @return the current position.
     */
    public Point getCurrentPosition() {
        return this.currentPosition;
    }

    /**
     * Return the list of questions in the maze.
     * @return the list of questions
     */
    public List<Question> getQuestions() {
        return this.questionList;
    }

    /**
     * Add questions into the question list of maze.
     * @param question the question
     */
    public void attachQuestion(Question question)
    {
        // assume all questions are different
        this.questionList.add(question);
    }

    /**
     * Add question from a list into the question list of maze.
     * @param questions the question list
     */
    public void attachQuestions(List<Question> questions)
    {
        this.questionList.addAll(questions);
    }

    /**
     * Remove question from the question list of maze.
     * @param question the question
     */
    public void detachQuestion(Question question)
    {
        this.questionList.remove(question);
    }

    /**
     * Clear all questions in the question list of maze.
     */
    public void clearQuestions()
    {
        this.questionList.clear();
    }

    /**
     * Get a random question in the question list of maze.
     * @return the random question
     */
    public Question getRandomQuestion()
    {
        int arbitaryIndex = this.random.nextInt(this.questionList.size());
        return this.questionList.get(arbitaryIndex);
    }

    /**
     * Set number of hints in the maze.
     * @param hints the number of hints
     */
    public void setHints(int hints)
    {
        this.hints = hints;
    }

    /**
     * Get the number of hints in the maze.
     * @return the number of hints in the maze
     */
    public int getHints() {
        return this.hints;
    }

    /**
     * Increase the number of hints.
     */
    public void increaseHint()
    {
        this.hints++;
    }

    /**
     * Decrease the number of hints.
     */
    public void decreaseHint()
    {
        this.hints--;
    }

    /**
     * The current position of user move up.
     */
    public void goUp() {
        currentPosition.setX(currentPosition.getX()-1);
    }

    /**
     * The current position of user move down.
     */
    public void goDown() {
        currentPosition.setX(currentPosition.getX()+1);
    }

    /**
     * The current position of user move to the left.
     */
    public void goLeft() {
        currentPosition.setY(currentPosition.getY()-1);
    }

    /**
     * The current position of user move to the right.
     */
    public void goRight() {
        currentPosition.setY(currentPosition.getY()+1);
    }

    /**
     * Create a string representative of the maze object.
     * @return the string representative of the maze object
     */
    public String toString() {
        return "Maze by " + width + "x" + height;
    }
    public boolean canMove (String str){
        if (str.equals("WEST")){
            return this.currentPosition.getY()-1>=0;
        }
        else if(str.equals("NORTH")){
            return this.currentPosition.getX()-1 >=0;
        }
        else if(str.equals("SOUTH")){
            return this.currentPosition.getX()+1<this.height;
        }
        else if(str.equals("EAST")){
            return this.currentPosition.getY()+1<this.width;
        }
        else return false;
    }
    public void setPosition (int x , int y){
        this.currentPosition.setX(x);
        this.currentPosition.setY(y);
    }
    public boolean checkWin (){
        return this.currentPosition.getX() == 4 && this.currentPosition.getY() == 3;
    }
    public boolean checkLose (){
        return ((!canMove("WEST")||!this.getRoom().isDoorOpen(Room.Door.WEST))
                &&(!canMove("NORTH")||!this.getRoom().isDoorOpen(Room.Door.NORTH))
                &&(!canMove("EAST")||!this.getRoom().isDoorOpen(Room.Door.EAST))
                &&(!canMove("SOUTH")||!this.getRoom().isDoorOpen(Room.Door.SOUTH)));
    }
}
