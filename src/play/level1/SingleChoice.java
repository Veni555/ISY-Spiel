package play.level1;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import play.level1.controller.SingleChoiceLv1Controller;

/**
 * Created by YiDao on 23.06.2017.
 */
public class SingleChoice extends Application{

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/singleChoice.fxml"));
        primaryStage.setTitle("MCI lernen, Spaß machen");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
