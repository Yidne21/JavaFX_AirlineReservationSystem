import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.BookedTicket;
import model.DataAccessQueries;

public class BookedTicketController implements Initializable {

    @FXML
    private TextField TcketIDTF;

    @FXML
    private TableColumn<BookedTicket, String> bookDateColumn;

    @FXML
    private TableColumn<BookedTicket, Integer> colSeatNumber;

    @FXML
    private TableColumn<BookedTicket, String> emalIdColumn;

    @FXML
    private TableColumn<BookedTicket, Integer> ColscheduleID;

    @FXML
    private TableColumn<BookedTicket, Integer> ticketPriceColumn;

    @FXML
    private TableView<BookedTicket> BookedtableView;
    public static TableView<BookedTicket> bTableView;

    @FXML
    private Button serachButton;

    @FXML
    void serachBtnClicked(ActionEvent event) throws SQLException {
        ObservableList<BookedTicket> data = FXCollections.observableArrayList();
        data.addAll(dataAccessQueries.getMyTicket(TcketIDTF.getText()));
        BookedtableView.setItems(data);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bTableView = BookedtableView;

        initTable();
        try {
            loadData();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
        data.addAll(dataAccessQueries.getBookedTickets());
        BookedtableView.setItems(data);
    }
}
