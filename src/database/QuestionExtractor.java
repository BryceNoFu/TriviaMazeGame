package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A class to run the extraction of questions from .txt file to an database .db file.
 * Only execute once, only if there is not questions database already available.
 *
 * @author Bryce Fukuda
 */
public class QuestionExtractor {

    public static void main(String[] args) {
        // establish connection object, to interact with db
        Connection connection = null;
        try {
            // connection to database
            connection = DriverManager.getConnection("jdbc:sqlite:src/database/questions.db");
            Statement statement = connection.createStatement(); // do commands to database
            statement.setQueryTimeout(15); // timeout set to 15 seconds

            // executeUpdate() to update the db
            statement.executeUpdate("DROP TABLE if EXISTS questionTable");
            statement.executeUpdate("CREATE TABLE questionTable (" +
                    "id INTEGER, " +
                    "type string," +
                    "question string, " +
                    "choice1 string, " +
                    "choice2 string, " +
                    "choice3 string, " +
                    "choice4 string, " +
                    "answer string," +
                    "hint string)");

            // read from .txt file and put into db file
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader("src/database/Q_List.txt"));
                String line = reader.readLine();
                while (line != null) {
                    String[] properties = line.split("\t");
                    statement.executeUpdate("INSERT INTO questionTable VALUES(" +
                            Integer.parseInt(properties[0]) + ", '" + // id
                            properties[1] + "', '" + // type
                            properties[2] + "', '" + // question
                            properties[3] + "', '" + // choice1
                            properties[4] + "', '" + // choice2
                            properties[5] + "', '" + // choice3
                            properties[6] + "', '" + // choice4
                            properties[7] + "', '" + // answer
                            properties[8] + "')");   // hint
                    line = reader.readLine();
                }
                reader.close();
            } catch(IOException e) {
                e.printStackTrace();
            }

            // executeQuery() to retrieve from db
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
        }


    }
}
