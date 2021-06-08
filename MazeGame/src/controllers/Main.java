package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;

/**
 * JavaFX application.
 */
public class Main extends Application {

    /**
     * Creates the main entry point for JavaFX Application.
     * @param primaryStage the primary stage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/Scene1.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        String file = new File("src/resources/Monkeys-Spinning-Monkeys.mp3").getAbsolutePath();
        Media media = new Media(new File(file).toURI().toString());
        AudioClip audioClip = new AudioClip(media.getSource());
        audioClip.play();
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }

    /**
     * Launches the JavaFX application.
     * @param args
     */
    public static void main(String... args) {
        launch(args);
    }

}
