package controllers;

import maze.*;
import questions.Question;
import questions.QuestionList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * A controller class that allows the user to switch to different scene, save or load game
 * and navigate though the maze by answering the question correctly.
 */
public class Controller implements Initializable {

    /** The start position. */
    private double x = 0;

    /** The start position. */
    private double y = 0;

    /** The change in x-coordinate. */
    private final double X_AMOUNT = 93;

    /** The change in y-coordinate. */
    private final double Y_AMOUNT = 60;

    /** The node object. */
    private Node node;

    /** The stage object. */
    private Stage stage;

    /** The scene object. */
    private Scene scene;

    /** The question list. */
    private QuestionList question = new QuestionList();

    /** A maze by 5x5, with 3 hints and the start position at (0,1). */
    private Maze maze = new Maze(5,5,3,new Point(0,1));

    /** The question list. */
    private FileChooser fileChooser = new FileChooser();

    /** The x-coordinate of character. */
    private  double charX;

    /** The y-coordinate of character. */
    private  double charY;

    /** The media object. */
    private Media media;

    /** The media player object. */
    private MediaPlayer mediaPlayer;

    /** The AnchorPane object for maze pane. */
    @FXML
    private AnchorPane Move;

    /** The text box for short answer questions. */
    @FXML
    private Text textQuestion;

    /** The radiobutton for multiple choice. */
    @FXML
    private RadioButton Box1;

    /** The radiobutton for multiple choice. */
    @FXML
    private RadioButton Box2;

    /** The radiobutton for multiple choice. */
    @FXML
    private RadioButton Box3;

    /** The radiobutton for multiple choice. */
    @FXML
    private RadioButton Box4;

    /** The ToggleGroup for multiple choice. */
    @FXML
    private ToggleGroup toggleGroup;

    /** The AnchorPane for question pane. */
    @FXML
    private AnchorPane questionPane;

    /** The AnchorPane for room pane. */
    @FXML
    private BorderPane roomPane;

    /** The question. */
    private Question q;

    /** The door direction. */
    private String door;

    /** The AnchorPane for True/False question pane. */
    @FXML
    private AnchorPane TFQuestionPane;

    /** The text box for True/False question. */
    @FXML
    private Text TFTextQuestion;

    /** The RadioButton for True answer. */
    @FXML
    private RadioButton TrueAnswer;

    /** The RadioButton for False answer. */
    @FXML
    private RadioButton FalseAnswer;

    /** The AnchorPane for Short question pane. */
    @FXML
    private AnchorPane ShortQuestionPane;

    /** The text box for short question. */
    @FXML
    private Text ShortQuestion;

    /** The text box for short question's answer. */
    @FXML
    private TextField ShortAnswer;

    /** The hint button for Multiple Choice question. */
    @FXML
    private Button Hint;

    /** The hint button for short question. */
    @FXML
    private Button HintShort;

    /** The hint button for True/False question. */
    @FXML
    private Button HintTF;

    /** The submit button for submitting answer. */
    @FXML
    private Button submit;

    /**
     * Returns the translate x of character.
     * @return the translate x of character.
     */
    private double getCharX() {
        return this.charX = Move.getTranslateX();
    }

    /**
     * Returns the translate y of character.
     * @return the translate y of character.
     */
    private double getCharY() {
        return this.charY = Move.getTranslateY();
    }

    /**
     * A method for mouse drag.
     * @param event the action event
     */
    @FXML
    void dragged (MouseEvent event) {
        node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        stage.setX(event.getSceneX() + x);
        stage.setY(event.getSceneY() +y);
    }


    /**
     * A method for mouse press.
     * @param event the action event
     */
    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();

    }

    /**
     * A method that allows the user to quit the game.
     * @param event the action event
     */
    @FXML
    void quit(MouseEvent event) {
        System.exit(0);
    }

    /**
     * A method that switches to Main menu.
     * @param event the action event
     * @throws IOException
     */
    @FXML
    void switchToScene1 (ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../view/Scene1.fxml"));
        node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * A method that switches to About scene.
     * @param event the action event
     * @throws IOException
     */
    @FXML
    void switchToAboutScene (ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../view/About.fxml"));
        node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * A method that switches to Maze field scene.
     * @param event the action event
     * @throws IOException
     */
    @FXML
    void switchToField (ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../view/Field.fxml"));
        node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    /**
     * A method that allows the users to move to different room
     * when they answer the question correct.
     * @param event the action event
     * @throws IOException
     */
    @FXML
    void clickedMove(MouseEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("The door's locked!!!");
        door = event.getPickResult().getIntersectedNode().getId();
        if (!maze.canMove(door) || (!maze.getRoom().isDoorOpen(Room.Door.WEST)&&door.equals("WEST"))){
            alert.show();
        }
        else if (!maze.canMove(door) || (!maze.getRoom().isDoorOpen(Room.Door.NORTH)&&door.equals("NORTH"))){
            alert.show();
        }
        else if (!maze.canMove(door) || (!maze.getRoom().isDoorOpen(Room.Door.EAST)&&door.equals("EAST"))){
            alert.show();
        }
        else if (!maze.canMove(door) || (!maze.getRoom().isDoorOpen(Room.Door.SOUTH)&&door.equals("SOUTH"))){
            alert.show();
        }
        else{
            roomPane.setVisible(false);
            q = question.getQuestion();
            String[] arr = q.getChoices();
            if (q.getType().toString().equals("MC")) {
                questionPane.setVisible(true);
                textQuestion.setTextAlignment(TextAlignment.CENTER);
                textQuestion.setText(q.getQuestionStr());
                Box1.setText(arr[0]);
                Box2.setText(arr[1]);
                Box3.setText(arr[2]);
                Box4.setText(arr[3]);
            }
            else if (q.getType().toString().equals("TF")){
                TFQuestionPane.setVisible(true);
                TFTextQuestion.setTextAlignment(TextAlignment.CENTER);
                TFTextQuestion.setText(q.getQuestionStr());
                TrueAnswer.setText(arr[0]);
                FalseAnswer.setText(arr[1]);
            }
            else if (q.getType().toString().equals("SHORT")){
                ShortQuestionPane.setVisible(true);
                ShortQuestion.setTextAlignment(TextAlignment.CENTER);
                ShortQuestion.setText(q.getQuestionStr());
            }
        }
    }

    /**
     * Creates an alert when the users win or lose.
     * @param event the action event
     */
    private void createAlert(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        if (maze.checkWin()) {
            String file = new File("src/resources/win1.wav").getAbsolutePath();
            playSound(file);
            alert.setHeaderText("You Win!!!!");
        }else if (maze.checkLose()){
            String file = new File("src/resources/lose1.wav").getAbsolutePath();
            playSound(file);
            alert.setHeaderText("You Lose!!!!");
        }

        ButtonType playAgainButton = new ButtonType("Play Again");

        ButtonType mainMenuButton = new ButtonType("Main Menu", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(playAgainButton, mainMenuButton);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == playAgainButton){
            Move.setTranslateX(0);
            Move.setTranslateY(0);
            maze = new Maze(5,5,3,new Point(0,1));
            question = new QuestionList();
        } else {
            try {
                switchToScene1(event);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Set the hint button disable when hint is zero.
     */
    void setHint (){
        if (maze.getHints()==0) {
            setDisableHint(true);
        }
        else {
            setDisableHint(false);
        }
    }

    /**
     * A method that takes a boolean value to set the hint button
     * disable or not.
     * @param bool the boolean value.
     */
    private void setDisableHint(Boolean bool) {
        if (q.getType().toString().equals("MC")) {
            Hint.setDisable(bool);
        }
        else if (q.getType().toString().equals("TF")) {
            HintTF = (Button)TFQuestionPane.lookup("#HintTF");
            HintTF.setDisable(bool);
        }
        else if (q.getType().toString().equals("SHORT")){
            HintShort = (Button)ShortQuestionPane.lookup("#HintShort");
            HintShort.setDisable(bool);
        }
    }

    /**
     * Creates the cheat button that allows the user to move to different room
     * without answering the questions.
     * @param event the action event
     */
    @FXML
    void cheatButton(ActionEvent event){
        setHint();
        TFQuestionPane.setVisible(false);
        ShortQuestionPane.setVisible(false);
        questionPane.setVisible(false);
        if (maze.canMove(door)) {
            moveCharacter(door);
        }
        if (maze.checkWin()){
            createAlert(event);
        }
    }

    /**
     * Creates the submit button when the user want to submit the answers.
     * @param event the action event
     */
    @FXML
    void submitButton(ActionEvent event) {
        setHint();
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Please choose answer!!");
        Alert alert2 = new Alert(Alert.AlertType.WARNING);
        alert2.setHeaderText("Door's locked!");
        Alert alert4 = new Alert(Alert.AlertType.WARNING);
        alert4.setHeaderText("Lose!!!!");
        RadioButton toggle = (RadioButton) toggleGroup.getSelectedToggle();
        if (q.getType().toString().equals("SHORT")){
            if (q.isCorrect(ShortAnswer.getText())){
                ShortQuestionPane.setVisible(false);
                String file = new File("src/resources/rightchoice.wav").getAbsolutePath();
                playSound(file);
                moveCharacter(door);
                if (maze.checkWin()) {
                    createAlert(event);
                }
            }
            else {
                roomPane.setVisible(true);
                ShortQuestionPane.setVisible(false);
                closeTheDoor(door);
                if (maze.checkLose()) {
                    createAlert(event);
                } else {
                    String file = new File("src/resources/Wrong-answer-sound-effect.mp3").getAbsolutePath();
                    playSound(file);
                    alert2.showAndWait();
                }
            }
        }else {
            if (toggleGroup.getSelectedToggle() == null && questionPane.isVisible() == true) {
                alert.showAndWait();
            } else {
                if (q.isCorrect(toggle.getText())) {
                    questionPane.setVisible(false);
                    TFQuestionPane.setVisible(false);
                    String file = new File("src/resources/rightchoice.wav").getAbsolutePath();
                    playSound(file);
                    moveCharacter(door);
                    if (maze.checkWin()) {
                        createAlert(event);
                    }
                } else {
                    roomPane.setVisible(true);
                    questionPane.setVisible(false);
                    TFQuestionPane.setVisible(false);
                    closeTheDoor(door);
                    if (maze.checkLose()) {
                        createAlert(event);
                    } else {
                        String file = new File("src/resources/Wrong-answer-sound-effect.mp3").getAbsolutePath();
                        playSound(file);
                        alert2.showAndWait();
                    }
                }
                toggleGroup.getSelectedToggle().setSelected(false);
            }
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    void hintButton(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(q.getHint() + "\n Remaining hint: " + (maze.getHints()-1));
        ButtonType buttonType = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        alert.getButtonTypes().setAll(buttonType);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonType){
            setDisableHint(true);
            maze.decreaseHint();
        }
    }

    /**
     * A method that takes file name and plays sound.
     * @param fileName the file name
     */
    private void playSound(String fileName) {
        Media media1 = new Media(new File(fileName).toURI().toString());
        MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
        mediaPlayer1.setVolume(.5);
        mediaPlayer1.play();
    }

    /**
     * A method that takes a direction string and close the door.
     * @param string the direction string
     */
    private void closeTheDoor (String string){
        if (string.equals("NORTH")) {
            maze.getRoom().closeDoor(Room.Door.NORTH);
        }
        else if (string.equals("WEST")){
            maze.getRoom().closeDoor(Room.Door.WEST);
        }
        else if (string.equals("EAST")){
            maze.getRoom().closeDoor(Room.Door.EAST);
        }
        else if (string.equals("SOUTH")){
            maze.getRoom().closeDoor(Room.Door.SOUTH);
        }
    }

    /**
     * A method that takes a direction string and move the character's position.
     * @param string a direction string
     */
    private void moveCharacter(String string){
        if (string.equals("NORTH")) {
            Move.setTranslateY(Move.getTranslateY() - Y_AMOUNT);
            maze.goUp();
            roomPane.setVisible(true);
        }
        else if (string.equals("WEST")){
            Move.setTranslateX(Move.getTranslateX()-X_AMOUNT);
            maze.goLeft();
            roomPane.setVisible(true);
        }
        else if (string.equals("EAST")){
            Move.setTranslateX(Move.getTranslateX()+X_AMOUNT);
            maze.goRight();
            roomPane.setVisible(true);
        }
        else {
            Move.setTranslateY(Move.getTranslateY()+Y_AMOUNT);
            maze.goDown();
            roomPane.setVisible(true);
        }
    }

    /**
     * A method that resets the character's position, maze, questionlist and sound.
     * @param event the action event
     */
    @FXML
    void reset(ActionEvent event) {
        Move.setTranslateX(0);
        Move.setTranslateY(0);
        maze = new Maze(5,5,3,new Point(0,1));
        question = new QuestionList();
        mediaPlayer.seek(Duration.ZERO);
    }

    /**
     * A method that allows the user to save game.
     * @param event the action event
     */
    @FXML
    void saveClicked(ActionEvent event) {

        try {
            ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream(new File("maze.dat")));
            out1.writeObject(new Store(maze, question));
            ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream(new File("maze.bin")));
            List<Double> list = new ArrayList<>();
            list.add(this.getCharX());
            list.add(this.getCharY());
            out2.writeObject(list);
            out1.close();
            out2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * A method that allows the user to load game.
     * @param event the action event
     */
    @FXML
    void loadClicked(ActionEvent event) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("maze.dat")));
            Store store = (Store) in.readObject();
            maze = store.getMaze();
            question = store.getQuestions();
            ObjectInputStream in1 = new ObjectInputStream(new FileInputStream(new File("maze.bin")));
            List<Double> list = (List<Double>) in1.readObject();
            Move.setTranslateX(0);
            Move.setTranslateY(0);
            Move.setTranslateX(Move.getTranslateX() + list.get(0));
            Move.setTranslateY(Move.getTranslateY() + list.get(1));
            mediaPlayer.seek(Duration.ZERO);
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("The file does not exist!!");
        }
    }


    /**
     * A method that switches to the loaded game scene.
     * @param event the action event
     * @throws IOException
     */
    @FXML
    void switchToLoadField (ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../view/Field.fxml"));
        node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("maze.dat")));
            Store store = (Store) in.readObject();
            maze = store.getMaze();
            question = store.getQuestions();
            ObjectInputStream in1 = new ObjectInputStream(new FileInputStream(new File("maze.bin")));
            List<Double> list = (List<Double>) in1.readObject();
            Move = (AnchorPane) scene.lookup("#Move");
            Move.setTranslateX(Move.getTranslateX() + list.get(0));
            Move.setTranslateY(Move.getTranslateY() + list.get(1));
            mediaPlayer.seek(Duration.ZERO);
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("The file does not exist!!");
        }
        stage.show();
    }

    /**
     * Initializes the game.
     * @param location the url
     * @param resources the resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String file = new File("src/resources/Monkeys-Spinning-Monkeys.mp3").getAbsolutePath();
        media = new Media(new File(file).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(.05);
        mediaPlayer.play();
        fileChooser.setInitialDirectory(new File("C:/Users/Nat/Desktop/TCSS360/git/Trivia/javafx/TriviaMazeGame/MazeGame"));
    }
}
