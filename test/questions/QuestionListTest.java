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
    void getSize() {
        assertEquals(100, qList.getSize(), "Default size 100.");
        qList.getQuestion(); // remove a question
        assertEquals(99, qList.getSize(), "99 questions after 1 removal.");
    }

    @Test
    void isEmpty() {
        assertFalse(qList.isEmpty());
        while (!qList.isEmpty()) {
            qList.getQuestion();
        }

        assertTrue(qList.isEmpty(), "Empty after complete removal of questions.");
    }

    @Test
    void getQuestion() {
        assertEquals(100, qList.getSize(), "Default size 100, question 1 still in.");
        Question testQ = QuestionFactory.createQuestion(
                "mc",
                1,
                "The capital of Washington state is what city?",
                "Tacoma",
                "Olympia",
                "Seattle",
                "Spokane",
                "Olympia",
                "Located in the southern Puget Sound region."
                );
        Question q = qList.getQuestion(); // remove a question

        assertEquals(testQ.getId(), q.getId(), "Should have same id.");
        assertEquals(testQ.getType(), q.getType(), "Should have same type.");
        assertEquals(testQ.getQuestion(), q.getQuestion(), "Should have same question.");
        assertArrayEquals(testQ.getChoices(), q.getChoices(), "Should have same choices.");
        assertEquals(testQ.getAnswer(), q.getAnswer(), "Should have same answer.");
        assertEquals(testQ.getHint(), q.getHint(), "Should have same hint.");
        assertEquals(99, qList.getSize(), "99 questions after question 1 removal.");
    }

    // The randomness of the shuffle() method makes it hard to test, so assume the shuffle method works fine.
}