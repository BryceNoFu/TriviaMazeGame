package questions;

import java.io.Serializable;

/**
 * Question of type multiple choice. Four choices are given to
 * the player to pick from, one of the choices is the correct answer.
 *
 * @author Bryce Fukuda
 */
public class QuestionMC extends QuestionGeneral implements Serializable {
    // fields
    /**
     * Serialization for the question.
     */
    private static final long serialVersionUID = -6675422479491540488L;

    /**
     * String array to store four choices.
     */
    private String[] choices;

    // constructors
    public QuestionMC(int id, String question, String[] choices, String answer, String hint) {
        super(id, question, answer, hint);
        this.choices = choices;
        this.setType(Type.MC);
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
     * A multi-line string containing all components to the multiple
     * choice question class.
     *
     * @return id, question, 4 choices, answer, and hint for question
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("ID: " + getId() + "\n");
        str.append("Question: " + getQuestion() + "\n");
        str.append("Choices: " + "\n");
        for (int i = 1; i <= getChoices().length; i++) {
            str.append(i + ": " + getChoices()[i-1] + "\n");
        }
        str.append("Answer: " + getAnswer() + "\n");
        str.append("Hint: " + getHint() + "\n");

        return str.toString();
    }
}
