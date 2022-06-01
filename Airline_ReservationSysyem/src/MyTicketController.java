import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class MyTicketController {

    @FXML
    private TableColumn<?, ?> ColArrivalTime;

    @FXML
    private TableColumn<?, ?> ColDate;

    @FXML
    private TableColumn<?, ?> ColFrom;

    @FXML
    private TableColumn<?, ?> ColSeatNumber;

    @FXML
    private TableColumn<?, ?> ColTicketID;

    @FXML
    private TableColumn<?, ?> ColTo;

    @FXML
    private TextField SeatNumberTF;

    @FXML
    private TextField TicketIDTF;

    @FXML
    private TableColumn<?, ?> colCancel;

    @FXML
    private TableColumn<?, ?> colDestination;

    @FXML
    private TableColumn<?, ?> colEdit;

    @FXML
    private Button serachButton;

    @FXML
    void serachBtnClicked(ActionEvent event) {
    }

}
