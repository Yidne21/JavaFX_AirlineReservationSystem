
import java.io.IOException;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.DataAccessQueries;

public class ScheduleFlightController extends AdminDashbordController {

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
    @FXML
    public BorderPane MainBorderpane;
    private App main;

    // connect main class to controller
    public void setMain(App main) {
        this.main = main;
    }

    int confirm;
    DataAccessQueries database = new DataAccessQueries();

    @FXML
    void btnCancelClicked(ActionEvent event) throws IOException {
        PaneSwicher swicher = new PaneSwicher();
        Pane view = swicher.getPane("AdminUI/ScheduleFlight");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UI/AdminUI/AdminDashboard.fxml"));
        Parent root = loader.load();
        AdminDashbordController adminDashbordController = loader.getController();
        adminDashbordController.rootBorderpane.setCenter(view);
        stage = (Stage) btnCancel.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnSaveClicked(ActionEvent event) {
        if (flightNumberTF.getText() != "" && planeNumberTF.getText() != "" && fromTF.getText() != ""
                && toTF.getText() != "" && datePick.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) != ""
                && timeTF.getText() != ""
                && RoutTF.getText() != "" && AirpotNameTF.getText() != "" && ticketPriceTF.getText() != "") {

            System.out.println(flightNumberTF.getText());

            confirm = database.addSchedule(flightNumberTF.getText(), planeNumberTF.getText(), fromTF.getText(),
                    toTF.getText(), datePick.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    timeTF.getText(), RoutTF.getText(),
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
