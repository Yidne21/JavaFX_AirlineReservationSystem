
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import Utility.SceneSwitcher;
import model.DataAccessQueries;
import model.flightList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class FlightListController extends SceneSwitcher implements Initializable {

        @FXML
        private Button ButtonSearch;

        @FXML
        private TableView<flightList> flightlistTable;
        public static TableView<flightList> flightlistTable2;

        @FXML
        private TableColumn<flightList, Integer> ColScheduleNumber;

        @FXML
        private TableColumn<flightList, String> ColArrivalTime;

        @FXML
        private TableColumn<flightList, String> ColDate;

        @FXML
        private TableColumn<flightList, String> ColDestinatiionTime;

        @FXML
        private TableColumn<flightList, Integer> ColFlightNumber;

        @FXML
        private TableColumn<flightList, String> ColFromCity;

        @FXML
        private TableColumn<flightList, Integer> ColTicketPrice;

        @FXML
        private TableColumn<flightList, String> ColToCity;

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
        private TextField flightNumberTF;

        @FXML
        private TextField planeNumberTF;

        @FXML
        private AnchorPane rootAnchorPane;
        @FXML
        private JFXButton btnBook;

        PaneSwicher swicher = new PaneSwicher();

        @FXML
        void btnBookClicked(ActionEvent event) throws IOException {
                MainController mainController = new MainController();
                if (mainController.getIslogin()) {
                        PaneSwicher swicher = new PaneSwicher();
                        Pane view = swicher.getPane("UserUI/BookingConfirmation");
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("UI/UserUI/userDashboard.fxml"));
                        Parent root = loader.load();
                        userDashBoardController userDB = new userDashBoardController();
                        userDB = loader.getController();
                        userDB.rootBorderpane.setCenter(view);
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                } else {
                        PaneSwicher swicher = new PaneSwicher();
                        Pane view = swicher.getPane("CommenUI/login");
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("UI/CommenUI/Main.fxml"));
                        Parent root = loader.load();
                        mainController = loader.getController();
                        mainController.MainBorderpane.setCenter(view);
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                }

        }

        @FXML
        void btnBussiSeeseatClicked(ActionEvent event) {

        }

        @FXML
        void btnEcoSeeseatClicked(ActionEvent event) {

        }

        @FXML
        void ButtonSearchClicked(ActionEvent event) {

        }

        DataAccessQueries dataAccessQueries = new DataAccessQueries();

        @Override
        public void initialize(URL location, ResourceBundle resource) {
                flightlistTable2 = flightlistTable;
                initTable();
                loadData();
        }

        private void initTable() {
                initCols();
        }

        private void initCols() {
                ColFlightNumber.setCellValueFactory(
                                new PropertyValueFactory<flightList, Integer>("flightNumber"));
                ColScheduleNumber.setCellValueFactory(
                                new PropertyValueFactory<flightList, Integer>("schedule_id"));
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
                flightlistTable.setItems(data);
        }

}