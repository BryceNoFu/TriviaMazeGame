package test.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import questions.Question;
import questions.QuestionFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for QuestionFactoryTest, creating some sample questions and
 * determine if the fields are correctly set using the question creation
 * method.
 *
 * @author Bryce Fukuda
 */
class QuestionFactoryTest {
    /**
     * First question to test, set to multiple choice.
     */
    Question q1;

    /**
     * Second question to test, set to true/false.
     */
    Question q2;

    /**
     * Third question to test, set to short answer.
     */
    Question q3;

    /**
     * Instantiate the questions before each test method,
     * using createQuestion() method to make the questions.
     */
    @BeforeEach
    void setup() {
        q1 = QuestionFactory.createQuestion("mc", 1, "What is 1 + 1?", "1", "2", "3", "4", "2", "Not 11.");
        q2 = QuestionFactory.createQuestion("tf", 2, "Potato is a fruit.", "TRUE", "FALSE", "", "", "FALSE", "Vege.");
        q3 = QuestionFactory.createQuestion("short", 3, "USA declared independence in what year?", "", "", "", "", "1776", "July 4th.");
    }

    /**
     * Test for question types are set correctly.
     */
    @Test
    void testType() {
        assertEquals(Question.Type.MC, q1.getType());
        assertEquals(Question.Type.TF, q2.getType());
        assertEquals(Question.Type.SHORT, q3.getType());
    }

    /**
     * Test for question id's are set correctly.
     */
    @Test
    void testID() {
        assertEquals(1, q1.getId());
        assertEquals(2, q2.getId());
        assertEquals(3, q3.getId());
    }

    /**
     * Test for question strings are set correctly.
     */
    @Test
    void testQuestion() {
        assertEquals("What is 1 + 1?", q1.getQuestionStr());
        assertEquals("Potato is a fruit.", q2.getQuestionStr());
        assertEquals("USA declared independence in what year?", q3.getQuestionStr());
    }

    /**
     * Test for question answer choices are set correctly.
     */
    @Test
    void testChoices() {
        assertArrayEquals(new String[]{"1", "2", "3", "4"}, q1.getChoices());
        assertArrayEquals(new String[]{"TRUE", "FALSE"}, q2.getChoices());
        assertArrayEquals(new String[]{""}, q3.getChoices());
    }

    /**
     * Test for question answers are set correctly.
     */
    @Test
    void testAnswer() {
        assertEquals("2", q1.getAnswer());
        assertEquals("FALSE", q2.getAnswer());
        assertEquals("1776", q3.getAnswer());
    }

    /**
     * Test for question hints are set correctly.
     */
    @Test
    void testHint() {
        assertEquals("Not 11.", q1.getHint());
        assertEquals("Vege.", q2.getHint());
        assertEquals("July 4th.", q3.getHint());
    }
}