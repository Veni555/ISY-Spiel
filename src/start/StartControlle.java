package start;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StartControlle {

    @FXML
    public void startBtnClick(ActionEvent event) throws IOException {
        System.out.println("Start learning");
        switschScene("/learn/level1learn.fxml", event);
    }

    public void helpBtnClick(ActionEvent event) throws IOException {
        switschScene("/tutorial/help1.fxml", event);
    }

    public void switschScene(String path, ActionEvent event) throws IOException {
        Parent pa = FXMLLoader.load(getClass().getResource(path));
        Scene scene2 = new Scene(pa);
        Stage stage2 = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage2.setScene(scene2);
        stage2.show();

    }


}
