package questions;

import java.io.Serial;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * A class to retrieve the questions that are stored in the questions.db file and
 * store all questions into a list. SQLite commands are used to get the questions,
 * and methods for using the questions in the list are implemented.
 *
 * @author Bryce Fukuda
 */
public class QuestionList implements Serializable {
    @Serial
    private static final long serialVersionUID = 9191262959905779880L;
    // fields
    /**
     * List to store questions into.
     */
    private List<Question> questionList;

    // constructors
    /**
     * Constructor for QuestionList.
     */
    public QuestionList() {
        questionList = new ArrayList<>();
        obtainQuestions();
        shuffle();
    }

    // methods
    /**
     * Gets the questions from the db file and store them
     * into the List, stored as
     */
    private void obtainQuestions() {
        Connection connection = null;
        try {
            // connection to database
            connection = DriverManager.getConnection("jdbc:sqlite:src/database/questions.db");
            Statement statement = connection.createStatement(); // do commands to database
            statement.setQueryTimeout(15); // timeout set to 15 seconds
            String query = "SELECT * FROM questionTable";

            // query the table contents row-by-row
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String question = rs.getString("question");
                String choice1 = rs.getString("choice1");
                String choice2 = rs.getString("choice2");
                String choice3 = rs.getString("choice3");
                String choice4 = rs.getString("choice4");
                String answer = rs.getString("answer");
                String hint = rs.getString("hint");

                // store new question into list
                questionList.add(QuestionFactory.createQuestion(type, id, question, choice1, choice2, choice3, choice4, answer, hint));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the size of the question list.
     *
     * @return list size for the questions
     */
    public int getSize() {
        return questionList.size();
    }

    /**
     * Determines if the question list is empty.
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        if (questionList.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the first question from the list, removes the question from the list
     * afterwards.
     *
     * @return first question in the list
     */
    public Question getQuestion() {
        if (!isEmpty()) { // non-empty list
            Question question = questionList.get(0);
            questionList.remove(0);
            return question;
        } else {
            System.out.println("EMPTY LIST!");
            return null;
        }
    }

    /**
     * Shuffles the ordering of the questions inside the list.
     */
    private void shuffle() {
        Collections.shuffle(questionList);
    }



}
