
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DataAccessQueries;
import model.adminFlightList;

public class BookedTicketController implements Initializable {

    @FXML
    private DatePicker DateTF;

    @FXML
    private TextField TcketIDTF;

    @FXML
    private TableColumn<BookedTicket, String> bookDateColumn;

    @FXML
    private TableColumn<BookedTicket, String> FirstNameColumn;

    @FXML
    private TableColumn<BookedTicket, String> LastNameColumn;

    @FXML
    private TableColumn<BookedTicket, String> emalIdColumn;

    @FXML
    private TableColumn<BookedTicket, Integer> finalPriceColumn;

    @FXML
    private TableColumn<BookedTicket, String> flightNameColumn;

    @FXML
    private TableColumn<BookedTicket, String> mobileNoColumn;

    @FXML
    private TableColumn<BookedTicket, Integer> noOfPersonColumn;

    @FXML
    private Button serachButton;

    @FXML
    private TableColumn<BookedTicket, Integer> ticketPriceColumn;

    @FXML
    private TableColumn<BookedTicket, String> userNameColumn;

    @FXML
    private TableView<BookedTicket> tbview;

    @FXML
    void serachBtnClicked(ActionEvent event) {

    }

    DataAccessQueries dq = new DataAccessQueries();
    ObservableList<BookedTicket> f = FXCollections.observableArrayList();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
       


        FirstNameColumn.setCellValueFactory(new PropertyValueFactory<BookedTicket, String>("fname"));
        LastNameColumn.setCellValueFactory(new PropertyValueFactory<BookedTicket, String>("lname"));
        mobileNoColumn.setCellValueFactory(new PropertyValueFactory<BookedTicket,  String>("phone"));
        bookDateColumn.setCellValueFactory(new PropertyValueFactory<BookedTicket, String>("date"));
        emalIdColumn.setCellValueFactory(new PropertyValueFactory<BookedTicket, String>("email"));
        noOfPersonColumn.setCellValueFactory(new PropertyValueFactory<BookedTicket, Integer>("no_person"));
        ticketPriceColumn.setCellValueFactory(new PropertyValueFactory<BookedTicket, Integer>("ticket_price"));
        finalPriceColumn.setCellValueFactory(new PropertyValueFactory<BookedTicket, Integer>("total_price"));


        tbview.setItems(f);

    }


}
