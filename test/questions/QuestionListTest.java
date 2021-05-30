package questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the QuestionList class, containing unit tests and
 * methods testing for components of the class. The db file stored
 * in the database package will be part of this test.
 *
 * @author Bryce Fukuda
 */
class QuestionListTest {
    /**
     * A question list to test for.
     */
    QuestionList qList;

    /**
     * Instantiate the question list before each test method.
     */
    @BeforeEach
    void setup() {
        qList = new QuestionList();
    }

    /**
     * Test for size of the list.
     */
    @Test
    void testGetSize() {
        assertEquals(100, qList.getSize(), "Default size 100.");
        qList.getQuestion(); // remove a question
        assertEquals(99, qList.getSize(), "99 questions after 1 removal.");
    }

    /**
     * Test for boolean isEmpty() method.
     */
    @Test
    void testIsEmpty() {
        assertFalse(qList.isEmpty());
        while (!qList.isEmpty()) {
            qList.getQuestion();
        }

        assertTrue(qList.isEmpty(), "Empty after complete removal of questions.");
    }

    /**
     * Test if getters and fields are set up for the question properly.
     */
    @Test
    void getQuestion() {
        assertEquals(100, qList.getSize(), "Default size 100, question 1 still in.");
        Question q = qList.getQuestion(); // remove a question
        assertEquals(99, qList.getSize(), "99 questions after question 1 removal.");
    }

    /**
     * Test to see if one of the answer choices lead to an actual answer, for multiple
     * choice and true/false questions.
     */
    @Test
    void testAnswers() {
        while (!qList.isEmpty()) {
            Question q = qList.getQuestion();
            boolean hasAnswer = false;
            if (q.getType() == Question.Type.SHORT) {
                continue;
            } else {
                for (int i = 0; i < q.getChoices().length; i++) {
                    if (q.isCorrect(q.getChoices()[i])) {
                        hasAnswer = true;
                    }
                }
            }
            assertTrue(hasAnswer);
        }
    }
}