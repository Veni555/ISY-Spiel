package end;

import javafx.fxml.FXML;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView ;

public class SchlussControlle  {

    @FXML
    private ImageView turnGif;

    @FXML
    public void clickHandler() {
        turnGif.setImage(new Image("img/turntable.gif"));
    }


}
