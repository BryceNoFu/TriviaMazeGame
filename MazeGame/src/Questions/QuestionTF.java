package questions;

import java.io.Serializable;

/**
 * Question of type true or false. Player must pick
 * either true or false based on the statement of the question.
 *
 * @author Bryce Fukuda
 */
public class QuestionTF extends QuestionGeneral implements Serializable {
    // fields
    /**
     * Serialization for the question.
     */
    private static final long serialVersionUID = -230647009084190467L;

    /**
     * String array to store two choices (TRUE / FALSE).
     */
    private String[] choices;

    // constructors
    public QuestionTF(int id, String question, String[] choices, String answer, String hint) {
        super(id, question, answer, hint);
        this.choices = choices;
        this.setType(Type.TF);
    }

    // methods
    /**
     * {@inheritDoc}
     */
    @Override
    public String[] getChoices() {
        return choices;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("ID: " + getId() + "\n");
        str.append("Question: " + getQuestionStr() + "\n");
        str.append("Choices: TRUE or FALSE" + "\n");
        str.append("Answer: " + getAnswer() + "\n");
        str.append("Hint: " + getHint() + "\n");

        return str.toString();
    }
}
