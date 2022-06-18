
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ScheduleFlightController extends SceneSwitcher {

    @FXML
    private TextField AirpotNameTF;

    @FXML
    private TextField RoutTF;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private DatePicker datePick;

    @FXML
    private TextField flightNumberTF;

    @FXML
    private TextField fromTF;

    @FXML
    private TextField planeNumberTF;

    @FXML
    private TextField ticketPriceTF;

    @FXML

    private TextField timeTF;

    @FXML
    private TextField toTF;

    int confirm;
    User_Queries user_Queries = new User_Queries();
    String date;

    @FXML
    void btnCancelClicked(ActionEvent event) {
    }

    @FXML
    void btnSaveClicked(ActionEvent event) {
        if (flightNumberTF.getText() != "" && planeNumberTF.getText() != "" && fromTF.getText() != ""
                && toTF.getText() != "" && datePick.getPromptText() != "" && timeTF.getText() != ""
                && RoutTF.getText() != "" && AirpotNameTF.getText() != "" && ticketPriceTF.getText() != "") {
            confirm = user_Queries.addSchedule(flightNumberTF.getText(), planeNumberTF.getText(), fromTF.getText(),
                    toTF.getText(), datePick.getPromptText(), timeTF.getText(), RoutTF.getText(),
                    AirpotNameTF.getText(), ticketPriceTF.getText());
            if (confirm == 1) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setContentText("Sucsessfully entered");
                alert.show();
            } 
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("please fill All Field");
            alert.show();
        }

    }

}
