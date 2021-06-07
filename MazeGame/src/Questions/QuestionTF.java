package Questions;

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
    private final String[] choices;

    // constructors

    /**
     * Constructor to the true/false question class, parameters as question components.
     *
     * @param id question id
     * @param question question string
     * @param choices two choices (true or false)
     * @param answer answer to question
     * @param hint hint to question
     */
    QuestionTF(int id, String question, String[] choices, String answer, String hint) {
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

    /**
     * A multi-line string containing all components to the true/false
     * question class.
     *
     * @return id, question, 2 choices, answer, and hint for question
     */
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
