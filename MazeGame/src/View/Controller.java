package View;

import MazeAndRoom.*;
import Questions.Question;
import Questions.QuestionList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    double x = 0;
    double y = 0;
    private Node node;
    private Stage stage;
    private Scene scene;
    private QuestionList question = new QuestionList();
    private Maze maze = new Maze(5,5,3,new Point(0,1));
    private  double charX;
    private  double charY;
    private Save save;
    private ObservableList<Save> list;


    @FXML
    private AnchorPane fieldScene;
    FileChooser fileChooser = new FileChooser();
    @FXML
    private AnchorPane Move;

    @FXML
    private Text textQuestion;

    @FXML
    private RadioButton Box1;

    @FXML
    private RadioButton Box2;

    @FXML
    private RadioButton Box3;

    @FXML
    private RadioButton Box4;

    @FXML
    private ToggleGroup toggleGroup;
    @FXML
    private AnchorPane questionPane;
    @FXML
    private BorderPane roomPane;

    private Question q;
    private String door;



    @FXML
    void dragged (MouseEvent event) {
        node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        stage.setX(event.getSceneX() + x);
        stage.setY(event.getSceneY() +y);
    }
    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();

    }
    @FXML
    void quit(MouseEvent event) {
        System.exit(0);
    }
    @FXML
    void switchToScene1 (ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void switchToNewGameScene (ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("NewGameScene.fxml"));
        node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void switchToAboutScene (ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("About.fxml"));
        node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToField (ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Field.fxml"));
        node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


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
            questionPane.setVisible(true);
            q = question.getQuestion();
            String[] arr = q.getChoices();
            textQuestion.setTextAlignment(TextAlignment.CENTER);
            textQuestion.setText(q.getQuestionStr());
            Box1.setText(arr[0]);
            Box2.setText(arr[1]);
            Box3.setText(arr[2]);
            Box4.setText(arr[3]);
        }
    }
    @FXML
    void submitButton(ActionEvent event) {
        System.out.println(Move.getTranslateX());
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Please choose answer!!");
        Alert alert2 = new Alert(Alert.AlertType.WARNING);
        alert2.setHeaderText("Door's locked!");
        Alert alert3 = new Alert(Alert.AlertType.WARNING);
        alert3.setHeaderText("Win!!!!");
        Alert alert4 = new Alert(Alert.AlertType.WARNING);
        alert4.setHeaderText("Lose!!!!");
        RadioButton toggle = (RadioButton) toggleGroup.getSelectedToggle();
        if (toggleGroup.getSelectedToggle()==null&&questionPane.isVisible()==false){
            alert.show();
        }
        else {
            if (q.isCorrect(toggle.getText())) {
                questionPane.setVisible(false);
                if (door.equals("NORTH")) {
                    //need clean
                    Move.setTranslateY(Move.getTranslateY() - 60);
                    maze.goUp();
                    roomPane.setVisible(true);
                }
                else if (door.equals("WEST")){
                    Move.setTranslateX(Move.getTranslateX()-93);
                    maze.goLeft();
                    roomPane.setVisible(true);
                }
                else if (door.equals("EAST")){
                    Move.setTranslateX(Move.getTranslateX()+93);
                    maze.goRight();
                    roomPane.setVisible(true);
                }
                else if (door.equals("SOUTH")){
                    Move.setTranslateY(Move.getTranslateY()+60);
                    maze.goDown();
                    roomPane.setVisible(true);
                }
                if (maze.checkWin()){
                    alert3.show();
                }

            } else {
                alert2.show();
                roomPane.setVisible(true);
                questionPane.setVisible(false);
                if (door.equals("NORTH")) {
                    maze.getRoom().closeDoor(Room.Door.NORTH);
                }
                else if (door.equals("WEST")){
                    maze.getRoom().closeDoor(Room.Door.WEST);
                }
                else if (door.equals("EAST")){
                    maze.getRoom().closeDoor(Room.Door.EAST);
                }
                else if (door.equals("SOUTH")){
                    maze.getRoom().closeDoor(Room.Door.SOUTH);
                }
                if (maze.checkLose()){
                    alert4.show();
                }
            }
            toggleGroup.getSelectedToggle().setSelected(false);
        }
    }
    @FXML
    void saveClicked(ActionEvent event) {
        Window window = fieldScene.getScene().getWindow();
        fileChooser.setTitle("Save Dialog");
        fileChooser.setInitialFileName("Maze");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("dat","*.dat"),
                new FileChooser.ExtensionFilter("binary","*.bin"));
        try{
            File file = fileChooser.showSaveDialog(window);
            fileChooser.setInitialDirectory(file.getParentFile());
            String path = file.getAbsolutePath();
            FileOutputStream newFile = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(newFile);
            save = new Save(maze,charX,charY,question);
            out.writeObject(save);
        }catch (Exception e){

        }
    }

    @FXML
    void loadClicked(ActionEvent event) {
        Window window = fieldScene.getScene().getWindow();
        fileChooser.setTitle("Load Dialog");
        fileChooser.setInitialFileName("Maze");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("dat","*.dat"),
                new FileChooser.ExtensionFilter("binary","*.bin"));
        try{
            File file = fileChooser.showOpenDialog(window);
            fileChooser.setInitialDirectory(file.getParentFile());
            String path = file.getAbsolutePath();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            list = FXCollections.observableList((List<Save>) in.readObject());
            save = list.get(0);
            //save = (Save) in.readObject();
            setCharX(save.getCharX());
            setCharY(save.getCharY());
            question = save.getQuestion();
            maze.setPosition(2,2);
        }catch (Exception e){

        }
    }
    private void setCharY (double y){
        Move.setTranslateY(Move.getTranslateY()+y);
    }
    private void setCharX (double x){
        Move.setTranslateX(Move.getTranslateX()+x);
    }
    private double getCharX() {
        return this.charX = Move.getTranslateX();
    }
    private double getCharY() {
        return this.charY = Move.getTranslateY();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooser.setInitialDirectory(new File("/Users/thanhtien7596/Desktop/TCSS 360/TriviaMazeGame/MazeGame"));
    }
}
