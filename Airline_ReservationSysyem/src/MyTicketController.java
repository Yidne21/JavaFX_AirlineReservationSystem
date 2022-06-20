
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
import model.Ticket;

public class MyTicketController implements Initializable {

    @FXML
    private DatePicker DateTF;

    @FXML
    private TableColumn<Ticket, String> bookDateColumn;

    @FXML
    private TableColumn<Ticket, String> emalIdColumn;

    @FXML
    private TableColumn<Ticket, Integer> finalPriceColumn;

    @FXML
    private TextField byFirstName;

    @FXML
    private TableColumn<Ticket, String> flirstNameColumn;

    @FXML
    private TableColumn<Ticket, String> lastNameColumn;

    @FXML
    private TableColumn<Ticket, String> mobileNoColumn;

    @FXML
    private TableColumn<Ticket, Integer> noOfPersonColumn;

    @FXML
    private Button serachButton;

    @FXML
    private TableColumn<Ticket, Integer> ticketPriceColumn;

    @FXML
    private TableView<Ticket> tbview;

    @FXML
    void serachBtnClicked(ActionEvent event) {

    }

    DataAccessQueries dq = new DataAccessQueries();
    ObservableList<Ticket> f = FXCollections.observableArrayList();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // f.setAll(dq.ticket());

        // flirstNameColumn.setCellValueFactory(new PropertyValueFactory<Ticket,
        // String>("FirstName"));
        // lastNameColumn.setCellValueFactory(new PropertyValueFactory<Ticket,
        // String>("Lastname"));
        // mobileNoColumn.setCellValueFactory(new PropertyValueFactory<Ticket,
        // String>("phone"));
        // bookDateColumn.setCellValueFactory(new PropertyValueFactory<Ticket,
        // String>("date"));
        // emalIdColumn.setCellValueFactory(new PropertyValueFactory<Ticket,
        // String>("email"));
        // noOfPersonColumn.setCellValueFactory(new PropertyValueFactory<Ticket,
        // Integer>("no_person"));
        // ticketPriceColumn.setCellValueFactory(new PropertyValueFactory<Ticket,
        // Integer>("ticket_price"));
        // finalPriceColumn.setCellValueFactory(new PropertyValueFactory<Ticket,
        // Integer>("total_price"));

        // tbview.setItems(f);

    }

}
