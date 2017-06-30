package play.level1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * Created by Administrator on 11.06.2017.
 */
public class MultiChoiceControlle {
    @FXML
    private CheckBox choiceA;
    @FXML
    private CheckBox choiceB;
    @FXML
    private CheckBox choiceC;
    @FXML
    private CheckBox choiceD;
    @FXML
    private CheckBox choiceE;

    @FXML
    private Text showResult;

    @FXML
    private Button submitBtn;

    @FXML
    private Button goOnBtn;

    String[] selectedItems = new String[5];
    String[] demoRichtigResult = {"choice a", "choice d", "choice e"};

    /**
     * @param event
     * @return selectedItems array of selected items
     * @throws IOException
     */
   @FXML
   public String[] selectActionHandle (ActionEvent event) throws IOException {
       controlElement(choiceA, 0);
       controlElement(choiceB, 1);
       controlElement(choiceC, 2);
       controlElement(choiceD, 3);
       controlElement(choiceE, 4);

       for(int i = 0; i < selectedItems.length; i++) {
           if(selectedItems[i] != "" || !selectedItems[i].isEmpty()) {
               System.out.println(selectedItems[i]);
           }
       }
       return selectedItems;
   }

    /**
     * If an item is selected, then get the text of it and add into array
     * @param choice select item
     * @param index index in array
     */
   public void controlElement(CheckBox choice, int index) {
       if(choice.isSelected()) {
           selectedItems[index] = choice.getText();
       } else {
           selectedItems[index] = "";
       }
   }

    /**
     * Ob der Array von ausgewaehlten Items  den Loesungen entsprichen.
     * @param result
     * @param rightResult
     * @return
     */
    public boolean isResultRight(String[] result, String[] rightResult) {
       int counter = 0;
       for(int i = 0; i < result.length; i++) {
           if(hasElement(result[i], rightResult)) {
               counter++ ;
           }
       }
        return (counter == rightResult.length);
    }

    /**
     * Ob ein Element von ausgewaehlten Items im Array der richtige Loesung.
     * @param element
     * @param rightResult
     * @return
     */
    public boolean hasElement(String element, String[] rightResult) {
       boolean hasEle= false;
//       System.out.println("Element: " + element);
       for(int i = 0; i < rightResult.length; i++) {
//           System.out.println("Length of rightResult in hasElement: " + i);
           if(element == rightResult[i] || element.equals(rightResult[i])) {
               hasEle = true;
           }
       }
        return hasEle;
    }

    @FXML
    public void submitActionHandle(ActionEvent event) throws IOException {
        String right = "Korrekt! Sie haben 5 Punkte erhalten.";
        String falsch= "Falsch. Leider 5 Punkte werden ausgezogen.";
        if(isResultRight(selectActionHandle(event), demoRichtigResult)) {
            showResult.setText(right);
        } else {
            showResult.setText(falsch);
        }

        choiceA.setDisable(true);
        choiceB.setDisable(true);
        choiceC.setDisable(true);
        choiceD.setDisable(true);
        choiceE.setDisable(true);

        submitBtn.setDisable(true);
        goOnBtn.setDisable(false);
    }

    @FXML
    public void goOnClickHandle(ActionEvent event) throws IOException {

    }
}
