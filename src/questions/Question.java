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
    public String getHint();
}
