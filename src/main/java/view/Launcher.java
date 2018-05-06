package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
/**
 * Application class using JavaFX libraries.
 */
public class Launcher extends Application {

    /**
     * Starts the JavaFX application.
     *
     * @param primaryStage the primary stage.
     * @throws Exception if the errors appeared.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {


        Parent root = FXMLLoader.load(getClass().getResource("/thesis.fxml"));
        primaryStage.setTitle("Thesis");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * The main method of application.
     *
     * @param args the command-line arguments as an array od {@code String}
     */
    public static void main(String[] args) {
        launch(args);
    }
}

