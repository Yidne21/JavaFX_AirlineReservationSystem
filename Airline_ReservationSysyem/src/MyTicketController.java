import java.sql.SQLException;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import model.BookedTicket;
import model.DataAccessQueries;

public class MyTicketController {

    @FXML
    private TableView<BookedTicket> BookedtableView;

    @FXML
    private TableColumn<BookedTicket, Integer> ColscheduleID;

    @FXML
    private TableColumn<BookedTicket, String> bookDateColumn;

    @FXML
    private TableColumn<BookedTicket, Integer> colSeatNumber;

    @FXML
    private TableColumn<BookedTicket, String> emalIdColumn;

    @FXML
    private TableColumn<BookedTicket, Integer> ticketPriceColumn;

    public static TableView<BookedTicket> bTableView;

    @FXML
    private Button serachButton;

    @FXML
    private TextField SeatIDTF;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private TextField emailTf;

    @FXML
    void serachBtnClicked(ActionEvent event) throws SQLException {
        initTable();
        loadData();
    }

    @FXML
    void btnCancelClicked(ActionEvent event) throws SQLException {
        int success = dataAccessQueries.DeleteBookedSeat(Integer.parseInt(SeatIDTF.getText()));
        if (success == 1) {
            dataAccessQueries.UpdateSeat(Integer.parseInt(SeatIDTF.getText()), "avil");
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.contentTextProperty().set("Ticket Booked seccessfully");
            alert.show();
            ;
        }

    }

    DataAccessQueries dataAccessQueries = new DataAccessQueries();

    private void initTable() {
        initCols();
    }

    private void initCols() {
        ColscheduleID.setCellValueFactory(new PropertyValueFactory<BookedTicket, Integer>("schedule_id"));
        bookDateColumn.setCellValueFactory(new PropertyValueFactory<BookedTicket, String>("DATE_"));
        colSeatNumber.setCellValueFactory(new PropertyValueFactory<BookedTicket, Integer>("seatid"));
        emalIdColumn.setCellValueFactory(new PropertyValueFactory<BookedTicket, String>("email"));
        ticketPriceColumn.setCellValueFactory(new PropertyValueFactory<BookedTicket, Integer>("ticketPrice"));
    }

    private void loadData() throws SQLException {
        ObservableList<BookedTicket> data = FXCollections.observableArrayList();
        data.addAll(dataAccessQueries.getMyTicket(emailTf.getText()));
        BookedtableView.setItems(data);
    }

}
