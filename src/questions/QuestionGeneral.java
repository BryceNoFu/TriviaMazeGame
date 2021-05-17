package questions;

/**
 * Abstract class for question classes, containing the minimum
 * required methods that will be implemented for these questions.
 *
 * @author Bryce Fukuda
 */
public abstract class QuestionGeneral implements Question {
    // fields
    /**
     * Question id, 1 to 100.
     */
    private int id;

    /**
     * Question text to ask the player.
     */
    private String question;

    /**
     * Answer to the question.
     */
    private String answer;

    /**
     * Hint to the question.
     */
    private String hint;

    // constructors
    public QuestionGeneral(int id, String question, String answer, String hint) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.hint = hint;
    }

    // methods
    /**
     * {@inheritDoc}
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getQuestion() {
        return question;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAnswer() {
        return answer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getHint() {
        return hint;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCorrect(String playerAnswer) {
        if (this.answer.equals(playerAnswer)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Creates string of id, question, any choices, answer, and hint.
     *
     * @return String of all fields for question.
     */
    public abstract String toString();
}
