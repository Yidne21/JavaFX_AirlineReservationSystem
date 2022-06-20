import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Utility.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.Node;
import javafx.stage.Stage;
import model.DataAccessQueries;
import model.flightList;
import javafx.scene.Scene;

public class AdminFlightList extends SceneSwitcher implements Initializable {

    @FXML
    private Button deleteButton;

    @FXML
    private TableColumn<flightList, Integer> ColScheduleNumber;

    @FXML
    private TableColumn<flightList, String> ColArrivalTime;

    @FXML
    private TableColumn<flightList, String> ColDate;

    @FXML
    private TableColumn<flightList, String> ColDestinatiionTime;

    @FXML
    private TableColumn<flightList, Integer> ColTicketNumber;

    @FXML
    private TableColumn<flightList, String> ColFromCity;

    @FXML
    private TableColumn<flightList, Integer> ColTicketPrice;

    @FXML
    private TableColumn<flightList, String> ColToCity;
    @FXML
    private Button newButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextField ToCityTF;

    @FXML
    private TextField fromCityTF;

    @FXML
    private TextField scheduleNumberTF;

    @FXML
    private TableView<flightList> tbview;

    public static TableView<flightList> flightlistTable2;
    DataAccessQueries dataAccessQueries = new DataAccessQueries();

    @FXML
    void NewBtnCliked(ActionEvent event) throws IOException {
        PaneSwicher swicher = new PaneSwicher();
        Pane view = swicher.getPane("AdminUI/Addflight");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UI/AdminUI/AdminDashboard.fxml"));
        Parent root = loader.load();
        AdminDashbordController adminDashbordController = loader.getController();
        adminDashbordController.rootBorderpane.setCenter(view);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void deletBtnCliked(ActionEvent event) throws NumberFormatException, SQLException {
        if (scheduleNumberTF.getText() != null) {
            int success = dataAccessQueries.deleteFlightSchedule(Integer.parseInt(scheduleNumberTF.getText()));
            if (success == 1) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setContentText("Delete succed");
                alert.show();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("delete failed please try Again");
                alert.show();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("please Enter the schedule ID");
            alert.show();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        flightlistTable2 = tbview;
        initTable();
        loadData();
    }

    private void initTable() {
        initCols();
    }

    private void initCols() {
        ColScheduleNumber.setCellValueFactory(
                new PropertyValueFactory<flightList, Integer>("schedule_id"));
        ColTicketNumber.setCellValueFactory(
                new PropertyValueFactory<flightList, Integer>("ticketId"));
        ColDate.setCellValueFactory(
                new PropertyValueFactory<flightList, String>("date"));
        ColFromCity.setCellValueFactory(new PropertyValueFactory<flightList, String>("from"));
        ColToCity.setCellValueFactory(new PropertyValueFactory<flightList, String>("destination"));
        ColArrivalTime.setCellValueFactory(new PropertyValueFactory<flightList, String>("arrival_time"));
        ColDestinatiionTime
                .setCellValueFactory(new PropertyValueFactory<flightList, String>("destination_time"));
        ColTicketPrice.setCellValueFactory(new PropertyValueFactory<flightList, Integer>("ticket_price"));
    }

    private void loadData() {
        ObservableList<flightList> data = FXCollections.observableArrayList();
        data.addAll(dataAccessQueries.getflightLists());
        tbview.setItems(data);
    }

    @FXML
    void SearchBtnClicked(ActionEvent event) {
        if (fromCityTF.getText() != null && ToCityTF.getText() != null) {
            ObservableList<flightList> data = FXCollections.observableArrayList();
            data.addAll(dataAccessQueries.getflightListsFillter(fromCityTF.getText(),
                    ToCityTF.getText()));
            tbview.setItems(data);
        }
    }

}
