package questions;

/**
 * Question of type true or false. Player must type the
 * answer based on the statement of the question.
 *
 * @author Bryce Fukuda
 */
public class QuestionSHORT extends QuestionGeneral{
    // fields

    // constructors
    public QuestionSHORT(int id, String question, String answer, String hint) {
        super(id, question, answer, hint);
    }

    // methods

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("ID: " + getId() + "\n");
        str.append("Question: " + getQuestion() + "\n");
        str.append("Answer: " + getAnswer() + "\n");
        str.append("Hint: " + getHint() + "\n");

        return str.toString();
    }
}
