import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class AdminFlightList {

    @FXML
    private TableColumn<?, ?> airpotNameColumn;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private Button deleteButton;

    @FXML
    private TableColumn<?, ?> editColumn;

    @FXML
    private TableColumn<?, ?> flightNameColumn;

    @FXML
    private TableColumn<?, ?> fromCityColumn;

    @FXML
    private Button newButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchByFlightNo;

    @FXML
    private TextField searchByName;

    @FXML
    private TableColumn<?, ?> ticketPriceColumn;

    @FXML
    private TableColumn<?, ?> timeColumn;

    @FXML
    private TableColumn<?, ?> toCityColumn;

    @FXML
    void NewBtnCliked(ActionEvent event) {

    }

    @FXML
    void SearchBtnClicked(ActionEvent event) {

    }

    @FXML
    void deletBtnCliked(ActionEvent event) {

    }

}
