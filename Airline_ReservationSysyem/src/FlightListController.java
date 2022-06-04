import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
    private ListView<?> BussSeatlistView;

    @FXML
    private ListView<?> EcoSeatlistView;

    @FXML
    private Button btnBook;

    @FXML
    private TextField flightNumberTF;

    @FXML
    private TextField planeNumberTF;

    @FXML
    private AnchorPane rootAnchorPane;

    PaneSwicher swicher = new PaneSwicher();

    @FXML
    void btnBussiSeeseatClicked(ActionEvent event) {

    }

    @FXML
    void btnEcoSeeseatClicked(ActionEvent event) {

    }

    @FXML
    void ButtonSearchClicked(ActionEvent event) {

    }

    @FXML
    void btnBookClicked(ActionEvent event) {
        try {
            AnchorPane signUP = FXMLLoader.load(getClass().getResource("UI/UserUI/BookTicket.fxml"));
            rootAnchorPane.getChildren().setAll(signUP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
