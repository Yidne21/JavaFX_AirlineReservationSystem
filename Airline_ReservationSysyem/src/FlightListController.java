import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class FlightListController extends SceneSwitcher {

    @FXML
    private Button ButtonSearch;

    @FXML
    private TableColumn<?, ?> ColAirPortTime;

    @FXML
    private TableColumn<?, ?> ColArrivalTime;

    @FXML
    private TableColumn<?, ?> ColDate;

    @FXML
    private TableColumn<?, ?> ColDestinatiionTime;

    @FXML
    private TableColumn<?, ?> ColFlightNumber;

    @FXML
    private TableColumn<?, ?> ColFromCity;

    @FXML
    private TableColumn<?, ?> ColPlaneNumber;

    @FXML
    private TableColumn<?, ?> ColTicketPrice;

    @FXML
    private TableColumn<?, ?> ColToCity;

    @FXML
    private DatePicker DateDatePicker;

    @FXML
    private TextField FromCityTextField;

    @FXML
    private TextField ToCityTextField;

    @FXML
    private Button btnBook;

    @FXML
    private TextField flightNumberTF;

    @FXML
    private TextField planeNumberTF;

    @FXML
    void ButtonSearchClicked(ActionEvent event) {

    }

    @FXML
    void btnBookClicked(ActionEvent event) {
        try {
            root = getScene("UserUI/BookTicket");
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
