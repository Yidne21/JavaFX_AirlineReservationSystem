
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
        private TableColumn<flightList, Integer> ColTicketNumber;

        @FXML
        private TableColumn<flightList, String> ColFromCity;

        @FXML
        private TableColumn<flightList, Integer> ColTicketPrice;

        @FXML
        private TableColumn<flightList, String> ColToCity;

        @FXML
        private TextField FromCityTextField;

        @FXML
        private TextField ToCityTextField;
        @FXML
        private AnchorPane rootAnchorPane;
        @FXML
        private JFXButton btnBook;

        @FXML
        private TextField scheduleIDTF;

        PaneSwicher swicher = new PaneSwicher();

        @FXML
        void btnBookClicked(ActionEvent event) throws IOException {
                MainController mainController = new MainController();
                if (mainController.getIslogin()) {
                        BookTicketController bookTicketController = new BookTicketController();
                        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("UI/UserUI/BookTicket.fxml"));
                        Parent view = loader2.load();
                        bookTicketController = loader2.getController();
                        bookTicketController.setFlightNumberTF(scheduleIDTF.getText());
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
                flightlistTable.setItems(data);
        }

        @FXML
        void ButtonSearchClicked(ActionEvent event) {
                if (FromCityTextField.getText() != null && ToCityTextField.getText() != null) {
                        ObservableList<flightList> data = FXCollections.observableArrayList();
                        data.addAll(dataAccessQueries.getflightListsFillter(FromCityTextField.getText(),
                                        ToCityTextField.getText()));
                        flightlistTable.setItems(data);
                }

        }
}