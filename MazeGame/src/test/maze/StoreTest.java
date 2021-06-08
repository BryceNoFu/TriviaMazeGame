package test.maze;

import maze.Maze;
import maze.Store;
import questions.QuestionList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests of the Store class.
 * @author Natalie Nguyen Hong
 * @version Spring 2021
 */
class StoreTest {

    /** A store object to test. */
    private Store store;

    /**
     * Initializes the store object.
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        store = new Store(null, null);
    }

    /**
     * Test method for {@link Store#getMaze()}.
     */
    @org.junit.jupiter.api.Test
    void getMaze() {
        Maze maze = new Maze(5,5, 0);
        store = new Store(maze,null);
        assertEquals("Maze by 5x5", store.getMaze().toString());
    }

    /**
     * Test method for {@link Store#getQuestions()}.
     */
    @org.junit.jupiter.api.Test
    void getQuestions() {
        QuestionList questionList = new QuestionList();
        store = new Store(null, questionList);
        assertEquals(100, store.getQuestions().getSize());
    }
}