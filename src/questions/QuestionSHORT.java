package questions;

/**
 * Question of type true or false. Player must type the
 * answer based on the statement of the question.
 *
 * @author Bryce Fukuda
 */
public class QuestionSHORT extends QuestionGeneral {
    // fields

    /**
     * String array to store four choices.
     */
    private final String[] choices = {""};

    // constructors

    /**
     * Constructor for short question class, parameters for the question components.
     *
     * @param id question id
     * @param question question string
     * @param answer answer to question
     * @param hint hint to question
     */
    QuestionSHORT(int id, String question, String answer, String hint) {
        super(id, question, answer, hint);
        this.setType(Type.SHORT);
    }

    // methods

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] getChoices() {
        return choices;
    }

    /**
     * A multi-line string containing all components to the short
     * answer question class.
     *
     * @return id, question, answer, and hint for question
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("ID: " + getId() + "\n");
        str.append("Question: " + getQuestionStr() + "\n");
        str.append("Answer: " + getAnswer() + "\n");
        str.append("Hint: " + getHint() + "\n");

        return str.toString();
    }


}
