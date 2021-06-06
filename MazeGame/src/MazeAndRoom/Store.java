package MazeAndRoom;

import Questions.QuestionList;

import java.io.Serial;
import java.io.Serializable;

/**
 * Creates a store class to store maze and question list.
 * @author Natalie Nguyen Hong
 * @version Spring 2021
 */
public class Store implements Serializable {

    @Serial
    private static final long serialVersionUID = 4772045605330928586L;

    /** Maze objet. */
    private Maze maze;

    /** QuestionList objet. */
    private QuestionList questions;

    /**
     * Constructs a store object.
     * @param maze a maze object
     * @param questions a question list
     */
    public Store(Maze maze, QuestionList questions)
    {
        this.maze = maze;
        this.questions = questions;
    }

    /**
     * Returns a maze object.
     * @return a maze object
     */
    public Maze getMaze()
    {
        return maze;
    }

    /**
     * Returns a question list.
     * @return a question list
     */
    public QuestionList getQuestions()
    {
        return questions;
    }
}
