package end;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Schluss extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("schluss.fxml"));
        primaryStage.setTitle("MCI mit Spaß lernen!");
        primaryStage.setScene(new Scene(root, 1000, 750));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

