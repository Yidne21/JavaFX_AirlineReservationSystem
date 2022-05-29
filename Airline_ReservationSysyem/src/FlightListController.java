import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class FlightListController {

    @FXML
    private Button ButtonSearch;

    @FXML
    private TableColumn<?, ?> ColAirPortTime;

    @FXML
    private TableColumn<?, ?> ColArrivalTime;

    @FXML
    private TableColumn<?, ?> ColBook;

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
    void ButtonSearchClicked(ActionEvent event) {

    }

}
