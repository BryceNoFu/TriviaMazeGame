package questions;

/**
 * Factory to instantiate a class based on the given
 * question's type (multiple choice, true/false, or short answer).
 *
 * GIVEN THE UNIQUENESS OF EACH QUESTION CLASS, PROGRAMMING TO AN
 * INTERFACE WILL MAKE CHILD-SPECIFIC METHODS INACCESSIBLE. THIS FACTORY MIGHT NOT
 * BE USED IN THE FINAL ITERATION!
 *
 * @author Bryce Fukuda
 */
public class QuestionFactory {

    public static Question createQuestion(String type,
                                   int id,
                                   String questionStr,
                                   String choice1,
                                   String choice2,
                                   String choice3,
                                   String choice4,
                                   String answer,
                                   String hint) {

        if (type.equals("mc")) { // multiple choice
            String[] choices = {choice1, choice2, choice3, choice4};
            return new QuestionMC(id, questionStr, choices, answer, hint);
        } else if (type.equals("tf")) { // true/false
            String[] choices = {choice1, choice2};
            return new QuestionTF(id, questionStr, choices, answer, hint);
        } else if (type.equals("short")) {
            return new QuestionSHORT(id, questionStr, answer, hint);
        } else {
            return null;
        }

    }
}
