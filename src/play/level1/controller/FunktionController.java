package play.level1.controller;

import javafx.fxml.FXML;

/**
 * Created by YiDao on 24.06.2017.
 */
public class FunktionController {

    Level1Controller lv1c;
    @FXML
    SingleChoiceLv1Controller sc1c;

    public int pos;


    public void loadPositionFromSpielbrett(int p) {
        this.pos = p;
//        sc1c.position = this.pos;
        System.out.println("pos: " + pos);

    }

//    public int setPositionToAufgabe(){
//        return this.pos;
//    }
}
