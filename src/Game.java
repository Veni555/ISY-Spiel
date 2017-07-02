import javafx.fxml.FXML;
import play.level1.controller.Level1Controller;
import play.level1.controller.SingleChoiceLv1Controller;

public class Game {
@FXML
public Level1Controller level1Controller;
@FXML
public SingleChoiceLv1Controller singleChoice;
 
public int getScore(){
	int punkte=singleChoice.getScore();
	return punkte;
}
}