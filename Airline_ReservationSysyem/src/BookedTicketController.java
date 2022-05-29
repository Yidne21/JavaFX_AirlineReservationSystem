import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class BookedTicketController {

    @FXML
    private TableColumn<?, ?> bookDateColumn;

    @FXML
    private TableColumn<?, ?> emalIdColumn;

    @FXML
    private TableColumn<?, ?> finalPriceColumn;

    @FXML
    private TableColumn<?, ?> flightNameColumn;

    @FXML
    private TableColumn<?, ?> mobileNoColumn;

    @FXML
    private Button nextButton;

    @FXML
    private TableColumn<?, ?> noOfPersonColumn;

    @FXML
    private Button previousButton;

    @FXML
    private TextField searchByNameTextField;

    @FXML
    private TextField searchByemailIdextField;

    @FXML
    private Button serachButton;

    @FXML
    private TableColumn<?, ?> ticketPriceColumn;

    @FXML
    private TableColumn<?, ?> userNameColumn;

    @FXML
    void nextBtnCliked(ActionEvent event) {

    }

    @FXML
    void previousBtnCliked(ActionEvent event) {

    }

    @FXML
    void serachBtnClicked(ActionEvent event) {

    }

}
