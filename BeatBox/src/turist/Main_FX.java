package turist;/**
 * Created by Женя on 06.08.2017.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main_FX extends Application {


    @Override
    public void start(Stage primaryStage) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainFX.fxml"));
            primaryStage.setTitle("Турист 2.0");
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
