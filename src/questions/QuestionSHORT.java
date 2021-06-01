package questions;

import java.io.Serializable;

/**
 * Question of type true or false. Player must type the
 * answer based on the statement of the question.
 *
 * @author Bryce Fukuda
 */
public class QuestionSHORT extends QuestionGeneral implements Serializable {
    // fields

    /**
     * String array to store four choices.
     */
    private String[] choices = {""};

    // constructors
    QuestionSHORT(int id, String question, String answer, String hint) {
        super(id, question, answer, hint);
        this.setType(Type.SHORT);
    }

    // methods

    @Override
    public String[] getChoices() {
        return choices;
    }

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
