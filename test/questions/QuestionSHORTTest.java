package questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A test class to directly test methods and fields for the
 * QuestionSHORT class.
 *
 * @author Bryce Fukuda
 */
class QuestionSHORTTest {
    /**
     * Loaded SHORT question to test.
     */
    private QuestionSHORT shortQ;

    /**
     * Instantiate a short answer question before each method.
     */
    @BeforeEach
    void setup() {
        shortQ = new QuestionSHORT(5, "What year was the Rio Olympics?", "2016", "Before 2017.");
    }

    /**
     * Test method for testing implemented Question getter methods.
     */
    @Test
    void testQuestionFields() {
        assertEquals(5, shortQ.getId(), "id should be 5.");
        assertEquals("What year was the Rio Olympics?", shortQ.getQuestion(), "Ask about year of Rio Olympics.");
        assertEquals("2016", shortQ.getAnswer(), "2016.");
        assertEquals("Before 2017.", shortQ.getHint(), "Proper hint says before 2017.");
    }

    /**
     * Test method for isCorrect method, test out some input options to match the answer.
     */
    @Test
    void testIsCorrect() {
        assertTrue(shortQ.isCorrect("2016"), "Answer is 2016.");
        assertTrue(shortQ.isCorrect(shortQ.getAnswer()), "Should give back 2016.");
        assertFalse(shortQ.isCorrect("2017"), "Answer is 2016, wrong answer.");
        assertFalse(shortQ.isCorrect("Japan"), "Answer is 2016, bad input.");
    }
}