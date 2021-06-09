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
import java.net.URL;

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
    public void start(Stage primaryStage) throws Exception {
        // setup for background music
        //String file = new File("src/resources/Monkeys-Spinning-Monkeys.mp3").toString();
        URL resource = getClass().getClassLoader().getResource("resources/Monkeys-Spinning-Monkeys.wav");
        Media media = new Media(resource.toExternalForm());
        //Media media = new Media(getHostServices().getDocumentBase() + "src/resources/Monkeys-Spinning-Monkeys.wav");
        //new File(file).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(.05);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
        mediaPlayer.play();

        /* Alternative setup to music */
        //String file = new File("src/resources/Monkeys-Spinning-Monkeys.mp3").getAbsolutePath();
        //Media media = new Media(new File(file).toURI().toString());
        //AudioClip audioClip = new AudioClip(media.getSource());
        //audioClip.play(0.05);
        //audioClip.setCycleCount(AudioClip.INDEFINITE);

        Parent root = FXMLLoader.load(getClass().getResource("/view/Scene1.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

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
