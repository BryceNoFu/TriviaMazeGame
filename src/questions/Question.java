package questions;

/**
 * Abstract class for question classes.
 *
 * @author Bryce Fukuda
 */
public interface Question {

    /**
     * Getter method for id.
     *
     * @return question id
     */
    int getId();

    /**
     * Getter method for question text.
     *
     * @return question text
     */
    String getQuestion();

    /**
     * Getter method for answer.
     *
     * @return answer text
     */
    String getAnswer();

    /**
     * Getter method for hint.
     *
     * @return hint text
     */
    String getHint();

    /**
     * Checks if the player's choice is the correct answer
     * by comparing their input to the question's answer,
     * returns boolean of whether their answer is correct.
     *
     * @return true if player's answer matches the question answer,
     *         otherwise return false
     */
    boolean isCorrect(String playerAnswer);
}
