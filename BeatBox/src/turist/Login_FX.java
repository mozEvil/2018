package turist;/**
 * Created by Женя on 06.08.2017.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Login_FX extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginFX.fxml"));
            primaryStage.setTitle("Авторизация");
            primaryStage.setScene(new Scene(root, 350, 150));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
