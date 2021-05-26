package maze;

import questions.*;
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
        currentPosition.setY(currentPosition.getY()-1);
    }

    /**
     * The current position of user move down.
     */
    public void goDown() {
        currentPosition.setY(currentPosition.getY()+1);
    }

    /**
     * The current position of user move to the left.
     */
    public void goLeft() {
        currentPosition.setX(currentPosition.getX()-1);
    }

    /**
     * The current position of user move to the right.
     */
    public void goRight() {
        currentPosition.setX(currentPosition.getX()+1);
    }

    /**
     * Create a string representative of the maze object.
     * @return the string representative of the maze object
     */
    public String toString() {
        return "Maze by " + width + "x" + height;
    }
}
