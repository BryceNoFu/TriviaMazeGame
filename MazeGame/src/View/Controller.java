package View;

import Questions.Question;
import Questions.QuestionList;
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

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    double x = 0;
    double y = 0;
    private Node node;
    private Stage stage;
    private Scene scene;
    private QuestionList question = new QuestionList();
    private Dialog dialog = new Dialog();

    @FXML
    private AnchorPane fieldScene;
    FileChooser fileChooser = new FileChooser();
    @FXML
    private AnchorPane Move;
    @FXML
    private AnchorPane northDoor;

    @FXML
    private AnchorPane westDoor;

    @FXML
    private AnchorPane southDoor;

    @FXML
    private AnchorPane eastDoor;

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

    @FXML
    private Button submit;

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
    void moveChac(MouseEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("The door's locked!!!");
        door = event.getPickResult().getIntersectedNode().getId();
        if (Move.getTranslateY()==0&&door.equals("northDoor")){
            alert.show();

        }
        else if (Move.getTranslateX()==-93&&door.equals("westDoor")){
            alert.show();
        }
        else if (Move.getTranslateX()==279&&door.equals("eastDoor")){
            alert.show();
        }
        else if (Move.getTranslateY()==240&&door.equals("soutDoor")){
            alert.show();
        }
        else {
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
    void saveClicked(ActionEvent event) {
        Window window = fieldScene.getScene().getWindow();
        fileChooser.setTitle("Save Dialog");
        fileChooser.setInitialFileName("Maze");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("dat","*.dat"),
                new FileChooser.ExtensionFilter("text","*.txt"));
        try{
            File file = fileChooser.showSaveDialog(window);
            fileChooser.setInitialDirectory(file.getParentFile());
        }catch (Exception e){

        }
    }
    @FXML
    void submitButton(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Please choose answer!!");
        Alert alert2 = new Alert(Alert.AlertType.WARNING);
        alert2.setHeaderText("Door's locked!");
        RadioButton toggle = (RadioButton) toggleGroup.getSelectedToggle();
        if (toggleGroup.getSelectedToggle()==null&&questionPane.isVisible()==false){
            alert.show();
        }
        else {
            if (q.isCorrect(toggle.getText())) {
                roomPane.setVisible(true);
                southDoor.setVisible(true);
                westDoor.setVisible(true);
                northDoor.setVisible(true);
                eastDoor.setVisible(true);
                questionPane.setVisible(false);
                if (door.equals("northDoor")) {
                    Move.setTranslateY(Move.getTranslateY() - 60);
                }
                else if (door.equals("westDoor")){
                    Move.setTranslateX(Move.getTranslateX()-93);
                }
                else if (door.equals("eastDoor")){
                    Move.setTranslateX(Move.getTranslateX()+93);
                }
                else if (door.equals("southDoor")){
                    Move.setTranslateY(Move.getTranslateY()+60);
                }

            } else {
                alert2.show();
                roomPane.setVisible(true);
                questionPane.setVisible(false);
                if (door.equals("northDoor")) {
                    northDoor.setVisible(false);
                }
                else if (door.equals("westDoor")){
                    westDoor.setVisible(false);
                }
                else if (door.equals("eastDoor")){
                    eastDoor.setVisible(false);
                }
                else if (door.equals("southDoor")){
                    southDoor.setVisible(false);
                }
            }
            toggleGroup.getSelectedToggle().setSelected(false);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooser.setInitialDirectory(new File("/Users/thanhtien7596/Desktop/TCSS 360/TriviaMazeGame/MazeGame"));
    }
}
