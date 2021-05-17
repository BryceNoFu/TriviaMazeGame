package questions;

/**
 * Factory to instantiate a class based on the given
 * question's type (multiple choice, true/false, or short answer).
 *
 * @author Bryce Fukuda
 */
public class QuestionFactory {

    public Question createQuestion(String type,
                                   int id,
                                   String questionStr,
                                   String choice1,
                                   String choice2,
                                   String choice3,
                                   String choice4,
                                   String answer,
                                   String hint) {
        Question question = null;

        if (type.equals("mc")) { // multiple choice
            String[] choices = {choice1, choice2, choice3, choice4};
            question = new QuestionMC(id, questionStr, choices, answer, hint);
        } else if (type.equals("tf")) { // true/false
            String[] choices = {choice1, choice2};
            question = new QuestionTF(id, questionStr, choices, answer, hint);
        } else if (type.equals("short")) {
            question = new QuestionSHORT(id, questionStr, answer, hint);
        } else {
            return null;
        }

        return question;

    }
}
