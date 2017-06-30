package play.level1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class SingleChoiceLv1Controller implements Initializable{

    @FXML
    public Text frage;
    @FXML
	public RadioButton choice1;
    @FXML
    private RadioButton choice2;
    @FXML
    private RadioButton choice3;
    @FXML
    private RadioButton choice4;
    @FXML
    private ToggleGroup questionRadioGroup;
    @FXML
    private Text showResult;
    @FXML
    private Button submitBtn;
    @FXML
    private Button goOnBtn;
    @FXML
    public Label aktPunkte;

    public int punkte;
    public int position = 10;

    public String rightResult = "choice 3";

    


//    @FXML
//    public void initialize() {
//        frage.setText("????");
//    }
    public void setPosition(int p) {
        this.position = p;
    }


    public void setFrage(int position){
        System.out.println("case in SC " + position);
     
    }

    public void setFragen(int position) {
        switch (position) {
            case 1:
                //frage.setText("1. Der Mensch verfügt über 5 bekannte Sine: Sehen, Hören, Riechen, Schmecken und Tasten. Das Liefern von Informationen ist aber nicht gleichmäßig zwischen allen 5 verteilt. 80% werden durch ____ erworben und somit ist es das am meisten in der Mensch Computer Interaktion umgesetzen Sensor. ");
                choice1.setText("Schmecken");
                choice2.setText("Sehen");
                choice3.setText("Hören");
                choice4.setText("Tasten");
                rightResult = "Sehen";
                
                break;

            case 2:
              //  frage.setText("2. 95% aller Sehezellen des Auge sind Stäbchen. Sie sind ___");
                choice1.setText("Für das Sehen von Farben verantwortlich");
                choice2.setText("Nicht sehr empfindlich");
                choice3.setText("genau 3 Arten");
                choice4.setText("für die Graustufen verantwortlich");
                rightResult = "für die Graustufen verantwortlich";
                break;

            case 3:
                //frage.setText("3. Die Zapfen, im Gegensatz zu den Stäbchen. Sie sind ___");
                choice1.setText("für das Farbsehen verantwortlich");
                choice2.setText("durch eingebaute Farbpigmente für Rot, Grün und Gelb emfindlich");
                choice3.setText("für das Helligkeitsunterscheiden verantwortlich");
                choice4.setText("nur eine Art");
                rightResult = "für das Farbsehen verantwortlich";
                break;

            case 4:
               // frage.setText("4. Offensichtlich sind die von dem mänschlichen Auge wahrgenommenen Farben mehr als die vorhandenen Zapfen Typen. Damit wir mehr als 3 Farben unterscheiden können, spricht man von ___ ");
                choice1.setText("Substraktiver Farbmischung");
                choice2.setText("Additiver Farbmischung");
                choice3.setText("Keine");
                choice4.setText("Beide");
                rightResult = "Additiver Farbmischung";
                break;

            case 5:
                //frage.setText("5. Der Sternhimmel: Folgendes Phänomen ist am nächtlichen Sternhimmel zu beobachten: wenn man versucht einen besonders schwach sichtbaren Stern zu fixiern, verschwindet er. Wenn man aber daneben blickt, taucht er wieder auf. Eine Erklärung dafür wäre, dass..");
                choice1.setText("Die Zapfen weniger empfindlich als die Stäbchen sind");
                choice2.setText("Die Zapfen empfindlicher als die Stäbchen sind");
                choice3.setText("Es eine Stelle gibt, an der der Sehnerv in die Netzhaut austritt und da sich keine Rezeptoren befinden: der s.g. blinde Fleck");
                choice4.setText("Die Adaption des Auges ducrh die mittlere Helligkeit des gesamten Blickfelds bestimmt wird");
                rightResult = "Die Zapfen weniger empfindlich als die Stäbchen sind";
                
                aktPunkte.setText(String.valueOf(getScore()));
                break;

            case 6:
                //frage.setText("6. Das menschliche Auge ist in seine Peripherie besonders auf Bewegungen empfindlich. Als Resultat kann man _____ betrachten.");
                choice1.setText("Den blinden Fleck");
                choice2.setText("Simultankontrast");
                choice3.setText("Flimmern");
                choice4.setText("Laterale Hemmung");
                rightResult = "Flimmern";
                break;

            case 7:
                //frage.setText("7. Das Flimmern kann bei größeren Blidschirmen als störendes Effekt auftauchen. Um dies zu vermeiden setzt man für ergonomische Monitore eine untere Grenze von ___ .");
                choice1.setText("100Hz");
                choice2.setText("80Hz");
                choice3.setText("90Hz");
                choice4.setText("85Hz");
                rightResult = "85Hz";
                break;

            case 8:
                //frage.setText("8. Wahrnehmungsfehler wie der Simultankontrast oder der Hemann-Gitter sind oft zu betrachten. Bei denen wedren Farben oder Graustufen, die gleich sind, als verschieden wahrgenommen, oder es werden Objekte gesehen, die gar nicht da sind. Diese Phänomene kann man mit _____ erklären.");
                choice1.setText("dem Mach´sche Bänder");
                choice2.setText("der Dreifarbentheorie");
                choice3.setText("der Vorverarbeitung der wahrgenomenen Bildern von der Netzhaut, bevor sie ins Gehirn kommen");
                choice4.setText("der fehlender Fähigkeit des menschlichen Auges, direkt nebeneinanderligende Farben zu unterscheiden");
                rightResult = "der Vorverarbeitung der wahrgenomenen Bildern von der Netzhaut, bevor sie ins Gehirn kommen";
                break;

            case 9:
               // frage.setText("9. Bei der Gestaltung von Anwendungen kann die Umsetzung von sich bewegenden oder blikneden Objekten nützlich sein, da sie die Aufmerksamkeit direkt auf sich ziehen. Eine sinnvolle Umsetzung wäre zum Beispiel bei ___ .");
                choice1.setText("einem langen Textparagraph");
                choice2.setText("einem Fehlermeldung Fenster");
                choice3.setText("den Elementen eines Toolbars");
                choice4.setText("einem Start Button");
                rightResult = "einem Fehlermeldung Fenster";
                
                break;

            case 10:
                //frage.setText("10. Die Okulomotorische Kriterien für Tiefensehen sind ___ .");
                choice1.setText("in 2D Bilder anzuwenden");
                choice2.setText("nur durch ein eiziges Auge zu ermitteln");
                choice3.setText("sowohl durch ein einziges Auge als auch mit den beiden Augen zu ermitteln");
                choice4.setText("nur mit den beiden Augen zu ermitteln");
                rightResult = "nur mit den beiden Augen zu ermitteln";
                break;

            case 11:
                //frage.setText("11. Beim Hooveren jedes Objektes einer Menüliste  wächselt die Hintergrungfarbe des Objekts von Wieß auf Blau, um zu deuten, dass das Objekt anclickbar ist. Welches Getsaltgesetzt erklärt am besten dieses Benehmen?");
                choice1.setText("der Nähe");
                choice2.setText("der Vertrautheit");
                choice3.setText("der guten Gestalt");
                choice4.setText("des gemeinsamen Schicksals");
                rightResult = "des gemeinsamen Schicksals";
                
break;
            case 12:
               // frage.setText("12. Welche Kriterien für das Tiefensehen sind bei dem Parallax Scrolling umgesetzt?");
                choice1.setText("die okulomotorischen Kriterien ");
                choice2.setText("die bewegungsindizierten Tiefenkriterien");
                choice3.setText("die Gestaltgesetze");
                choice4.setText("des statischen Sehens");
                rightResult = "die bewegungsindizierten Tiefenkriterien";
                
                break;

            case 13:
               // frage.setText("13. Welcher von den folgenden Begriffen gehört nicht zu den monokularen Kriterien für Tiefsehen?");
                choice1.setText("Verdecken von Objekten");
                choice2.setText("relative Größe/Höhe im Blickfeld");
                choice3.setText("Bewegungsparallaxe");
                choice4.setText("Tiefenschärfe");
                rightResult = "Bewegungsparallaxe";
                
                break;

            case 14:
               // frage.setText("");
                choice1.setText("");
                choice2.setText("");
                choice3.setText("");
                choice4.setText("");
                rightResult = "";
               
                break;

            case 15:
               // frage.setText("");
                choice1.setText("");
                choice2.setText("");
                choice3.setText("");
                choice4.setText("");
                rightResult = "";
                break;
        }
        
    }



    @FXML
    public String selectActionHandle (ActionEvent event) throws IOException {
        RadioButton selectedRadio = (RadioButton) questionRadioGroup.getSelectedToggle();
        System.out.println(selectedRadio.getText());
        return selectedRadio.getText();
    }

    public boolean isResultRight(String result, String rightResult) {
        return (result == rightResult || result.equals(rightResult));
    }

    @FXML
    public void submitActionHandle(ActionEvent event) throws IOException {
        // load FXML-Datei level1play.fxml
        URL url = new File("src/play/level1/view/level1play.fxml").toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent parent = loader.load();
        Level1Controller controller = (Level1Controller)loader.getController();
        
        // score im Level1Controller lesen und speichern
        

        String right = "Korrekt! Sie haben 5 Punkte erhalten.";
        String falsch= "Falsch. Leider 5 Punkte werden ausgezogen.";
        if(isResultRight(selectActionHandle(event), this.rightResult)) {
            showResult.setText(right);
            punkte += 5;
            aktPunkte.setText(String.valueOf(punkte));
        } else {
            showResult.setText(falsch);
            punkte -= 5;
            aktPunkte.setText(String.valueOf(punkte));
        }

        choice1.setDisable(true);
        choice2.setDisable(true);
        choice3.setDisable(true);
        choice4.setDisable(true);

        submitBtn.setDisable(true);
        goOnBtn.setDisable(false);

        System.out.println("score2:" + punkte);

        // akualisiern Score im Aufgaben-Fenster
      setPunkte(punkte);
      aktPunkte.setText(String.valueOf(punkte));

    }
    public int getScore(){
    	return this.punkte;
    }
    public void setPunkte(int punkte){
    	this.punkte=punkte;
    }

    @FXML
    public void goOnClickHandle(ActionEvent event) throws IOException {
        Stage stage = (Stage) goOnBtn.getScene().getWindow();
        stage.close();
        
    }


    /*
        level1play.fxml
     */

    @FXML
    public void toStartBtnClick (ActionEvent event) throws IOException {
        System.out.println("back to start");
        switschScene("/start/start.fxml", event);
    }



    public void switschScene(String path, ActionEvent event) throws IOException {
        Parent pa = FXMLLoader.load(getClass().getResource(path));
        Scene scene2 = new Scene(pa);
        Stage stage2 = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage2.setScene(scene2);
        stage2.show();
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	
		setFragen((int)(Math.random() * 6 + 1));
		
	}

}
