package learn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Administrator on 22.05.2017.
 */
public class LearnControlle {
    @FXML
    public void toStartBtnClick(ActionEvent event) throws IOException {
        System.out.println("back to start");
        switschScene("/start/start.fxml", event);
    }

    @FXML
    public void playLevel1BtnClick(ActionEvent event) throws IOException {
        switschScene("/play/level1/view/level1play.fxml", event);
    }

    @FXML
    public void playLevel2BtnClick(ActionEvent event) throws IOException {
        switschScene("/play/level2/view/level2play.fxml", event);
    }

    public void switschScene(String path, ActionEvent event) throws IOException {
        Parent pa = FXMLLoader.load(getClass().getResource(path));
        Scene scene2 = new Scene(pa);
        Stage stage2 = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage2.setScene(scene2);
        stage2.show();

    }
    
}
