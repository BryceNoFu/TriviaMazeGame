package test.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import questions.Question;
import questions.QuestionTF;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A test class to directly test methods and fields for the
 * QuestionTF class.
 *
 * @author Bryce Fukuda
 */
class QuestionTFTest {
    /**
     * Loaded TF questions to test.
     */
    private QuestionTF tfQCorrect;
    private QuestionTF tfQIncorrect;

    /**
     * Instantiate true/false questions before each method.
     */
    @BeforeEach
    void setup() {
        tfQCorrect = new QuestionTF(3, "1 + 1 is 2.", new String[]{"TRUE", "FALSE"}, "TRUE", "not FALSE.");
        tfQIncorrect = new QuestionTF(4, "Dogs are plants.", new String[]{"TRUE", "FALSE"}, "FALSE", "not TRUE.");
    }

    /**
     * Test method for testing implemented Question getter methods.
     */
    @Test
    void testQuestionFields() {
        // assertions for the correct question
        assertEquals(3, tfQCorrect.getId(), "id should be 3.");
        assertEquals("1 + 1 is 2.", tfQCorrect.getQuestionStr(), "Ask about 1 + 1.");
        assertEquals("TRUE", tfQCorrect.getAnswer(), "TRUE.");
        assertEquals("not FALSE.", tfQCorrect.getHint(), "Proper hint says not FALSE.");

        // assertions for the incorrect question
        assertEquals(4, tfQIncorrect.getId(), "id should be 4.");
        assertEquals("Dogs are plants.", tfQIncorrect.getQuestionStr(), "Ask about dogs being plants.");
        assertEquals("FALSE", tfQIncorrect.getAnswer(), "FALSE.");
        assertEquals("not TRUE.", tfQIncorrect.getHint(), "Proper hint says not TRUE.");
    }

    /**
     * Test method for testing getChoices method, returning a string of
     * 2 possible choices (TRUE or FALSE).
     */
    @Test
    void testGetChoices() {
        // both questions should have same outputs
        assertArrayEquals(new String[]{"TRUE", "FALSE"}, tfQCorrect.getChoices());
        assertEquals("TRUE", tfQCorrect.getChoices()[0], "First element is TRUE.");
        assertEquals("FALSE", tfQCorrect.getChoices()[1], "Second element is FALSE.");
    }

    /**
     * Test method for isCorrect method, test out true and false options to match the answer.
     */
    @Test
    void testIsCorrect() {
        assertEquals(Question.Type.TF, tfQCorrect.getType(), "Should be TF.");
        assertFalse(tfQCorrect.isCorrect("FALSE"), "Answer is not FALSE.");
        assertTrue(tfQCorrect.isCorrect("TRUE"), "Answer is TRUE.");
        assertTrue(tfQCorrect.isCorrect(tfQCorrect.getAnswer()), "Should give back TRUE.");

        assertEquals(Question.Type.TF, tfQIncorrect.getType(), "Should be TF.");
        assertFalse(tfQIncorrect.isCorrect("TRUE"), "Answer is not TRUE.");
        assertTrue(tfQIncorrect.isCorrect("FALSE"), "Answer is FALSE.");
        assertFalse(tfQIncorrect.isCorrect(tfQCorrect.getAnswer()), "Should give back FALSE.");
    }

    /**
     * Test method for QuestionTF's toString method.
     */
    @Test
    void testToString() {
        assertEquals(
                "ID: 3\n" +
                        "Question: 1 + 1 is 2.\n" +
                        "Choices: TRUE or FALSE\n" +
                        "Answer: TRUE\n" +
                        "Hint: not FALSE.\n" ,
                tfQCorrect.toString(), "List out fields.");

        assertEquals(
                "ID: 4\n" +
                        "Question: Dogs are plants.\n" +
                        "Choices: TRUE or FALSE\n" +
                        "Answer: FALSE\n" +
                        "Hint: not TRUE.\n" ,
                tfQIncorrect.toString(), "List out fields.");
    }
}