package questions;

/**
 * Question of type true or false. Player must pick
 * either true or false based on the statement of the question.
 *
 * @author Bryce Fukuda
 */
public class QuestionTF extends QuestionGeneral {
    // fields
    /**
     * String array to store two choices (TRUE / FALSE).
     */
    private String[] choices;

    // constructors
    public QuestionTF(int id, String question, String[] choices, String answer, String hint) {
        super(id, question, answer, hint);
        this.choices = choices;
    }

    // methods
    /**
     * Getter method for the array of the two choices.
     *
     * @return array of choices
     */
    public String[] getChoices() {
        return choices;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("ID: " + getId() + "\n");
        str.append("Question: " + getQuestion() + "\n");
        str.append("Choices: TRUE or FALSE" + "\n");
        str.append("Answer: " + getAnswer() + "\n");
        str.append("Hint: " + getHint() + "\n");

        return str.toString();
    }
}
