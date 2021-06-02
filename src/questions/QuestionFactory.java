package questions;

/**
 * Factory to instantiate a class based on the given
 * question's type (multiple choice, true/false, or short answer).
 *
 * @author Bryce Fukuda
 */
public class QuestionFactory {

    /**
     * Creates a question class based on the type of question provided and arguments for the
     * class fields. "mc" for multiple choice, "tf" for true/false, and "short" for short answer.
     *
     * @param type question type and format
     * @param id question id, or number
     * @param questionStr question being asked
     * @param choice1 first answer choice
     * @param choice2 second answer choice
     * @param choice3 third answer choice
     * @param choice4 fourth answer choice
     * @param answer actual answer to question
     * @param hint hint for the question
     * @return constructed question class
     */
    public static Question createQuestion(String type,
                                   int id,
                                   String questionStr,
                                   String choice1,
                                   String choice2,
                                   String choice3,
                                   String choice4,
                                   String answer,
                                   String hint) {

        switch (type) {
            case "mc": { // multiple choice
                final String[] choices = {choice1, choice2, choice3, choice4};
                return new QuestionMC(id, questionStr, choices, answer, hint);
            }
            case "tf": { // true/false
                final String[] choices = {choice1, choice2};
                return new QuestionTF(id, questionStr, choices, answer, hint);
            }
            case "short": // short answer
                return new QuestionSHORT(id, questionStr, answer, hint);
            default:
                return null;
        }

    }
}
