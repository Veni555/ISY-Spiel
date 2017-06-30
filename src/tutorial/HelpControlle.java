package tutorial;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelpControlle {

//    private AnchorPane help1Content;
//    private AnchorPane help2Content;
//    private AnchorPane help3Content;
//    private AnchorPane help4Content;


    @FXML
    public void nextBtnClick1(ActionEvent event) throws IOException {
        System.out.println("next");
        switschScene("help2.fxml", event);
    }

    @FXML
    public void nextBtnClick2(ActionEvent event) throws IOException {
        System.out.println("next");
        switschScene("help3.fxml", event);
    }

    @FXML
    public void nextBtnClick3(ActionEvent event) throws IOException {
        switschScene("help4.fxml", event);
    }

    @FXML
    public void backBtnClick1(ActionEvent event) throws IOException {
        switschScene("help1.fxml", event);
    }

    @FXML
    public void backBtnClick2(ActionEvent event) throws IOException {
        switschScene("help2.fxml", event);
    }

    @FXML
    public void backBtnClick3(ActionEvent event) throws IOException {
        switschScene("help3.fxml", event);
    }

    @FXML
    public void backToStartBtnClick(ActionEvent event) throws IOException {
        System.out.println("Back to start");
        switschScene("/start/start.fxml", event);

    }

    public void switschScene(String path, ActionEvent event) throws IOException {
        Parent pa = FXMLLoader.load(getClass().getResource(path));
        Scene scene2 = new Scene(pa);
        Stage stage2 = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage2.setScene(scene2);
        stage2.show();

    }

}
