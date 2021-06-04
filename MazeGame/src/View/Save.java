package View;

import MazeAndRoom.Maze;
import Questions.QuestionList;

public class Save {
    private double charX;
    private double charY;
    private Maze maze;
    private QuestionList question;

    public Save (Maze maze , double charX, double charY, QuestionList question){
        this.maze = maze;
        this.charX = charX;
        this.charY = charY;
        this.question = question;
    }

    public double getCharX() {
        return charX;
    }

    public double getCharY() {
        return charY;
    }

    public Maze getMaze() {
        return maze;
    }

    public QuestionList getQuestion() {
        return question;
    }
}
