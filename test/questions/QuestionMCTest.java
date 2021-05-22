package questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A test class to directly test methods and fields for the
 * QuestionMC class.
 *
 * @author Bryce Fukuda
 */
class QuestionMCTest {
    /**
     * Loaded MC question to test.
     */
    private QuestionMC mcQ;

    /**
     * Instantiate a multiple choice question before each method.
     */
     @BeforeEach
     void setup() {
         mcQ = new QuestionMC(11, "What is 1 + 1?", new String[]{"1", "2", "3", "4"}, "2", "Not 11.");
     }

    /**
     * Test method for testing implemented Question getter methods.
     */
    @Test
     void testQuestionFields() {
        assertEquals(Question.Type.MC, mcQ.getType(), "Should be MC.");
        assertEquals(11, mcQ.getId(), "id should be 11.");
        assertEquals("What is 1 + 1?", mcQ.getQuestion(), "Ask about 1 + 1.");
        assertEquals("2", mcQ.getAnswer(), "2.");
        assertEquals("Not 11.", mcQ.getHint(), "Proper hint says not 11.");
     }

    /**
     * Test method for testing getChoices method, returning a string of
     * 4 possible choices.
     */
    @Test
    void testGetChoices() {
        assertArrayEquals(new String[]{"1", "2", "3", "4"}, mcQ.getChoices());
        for (int i = 0; i < mcQ.getChoices().length; i++) {
            assertEquals(Integer.toString(i+1), mcQ.getChoices()[i], "Loop from 1 to 4.");
        }
    }

    /**
     * Test method for isCorrect method, test out all four options to match the answer.
     */
    @Test
    void testIsCorrect() {
        assertFalse(mcQ.isCorrect("1"), "Answer is 2.");
        assertTrue(mcQ.isCorrect("2"), "Answer is 2.");
        assertTrue(mcQ.isCorrect(mcQ.getAnswer()), "Should give back 2.");
        assertFalse(mcQ.isCorrect("3"), "Answer is 2.");
        assertFalse(mcQ.isCorrect("4"), "Answer is 2.");
    }

    /**
     * Test method for QuestionMC's toString method.
     */
    @Test
    void testToString() {
        assertEquals(
                "ID: 11\n" +
                "Question: What is 1 + 1?\n" +
                "Choices: \n" +
                "1: 1\n" +
                "2: 2\n" +
                "3: 3\n" +
                "4: 4\n" +
                "Answer: 2\n" +
                "Hint: Not 11.\n" ,
                    mcQ.toString(), "List out fields.");
    }
}