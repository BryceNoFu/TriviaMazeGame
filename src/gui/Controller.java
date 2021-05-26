package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    double x = 0;
    double y = 0;
    private Node node;
    private Stage stage;
    private Scene scene;
    private Dialog dialog = new Dialog();
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
    private Button okButton;

    @FXML
    private DialogPane testDialog;

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
        Parent root = FXMLLoader.load(getClass().getResource("dialogTest.fxml"));
        Dialog dialog = new Dialog();
        dialog.getDialogPane().setContent(root);
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("There's no room");
        if(event.getPickResult().getIntersectedNode().getId().equals("northDoor")){
            if (Move.getTranslateY()==0){
                //alert.show();
                dialog.show();
                System.out.println("The're no door in North!!");
            }
        }
        if(event.getPickResult().getIntersectedNode().getId().equals("westDoor")){
            if (Move.getTranslateX()==0){
                System.out.println("The're no door!!");
            }
        }
//        if (Move.getTranslateX()<400) {
//            Move.setTranslateX(100 + Move.getTranslateX());
//            Move.setTranslateY(50);
//        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }



}
