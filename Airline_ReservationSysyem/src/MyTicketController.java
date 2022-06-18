
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class MyTicketController {

    @FXML
    private DatePicker DateTF;

    @FXML
    private TextField TcketIDTF;

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
    private TableColumn<?, ?> noOfPersonColumn;

    @FXML
    private Button serachButton;

    @FXML
    private TableColumn<?, ?> ticketPriceColumn;

    @FXML
    private TableColumn<?, ?> userNameColumn;

    @FXML
    void serachBtnClicked(ActionEvent event) {

    }

}
