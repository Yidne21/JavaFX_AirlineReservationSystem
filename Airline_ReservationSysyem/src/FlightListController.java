
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class FlightListController extends SceneSwitcher {

    @FXML
    private Button ButtonSearch;

    @FXML
    private TableView<Data> flightlistTable;

    @FXML
    private TableColumn<?, ?> ColAirPortTime;

    @FXML
    private TableColumn<?, ?> ColArrivalTime;

    @FXML
    private TableColumn<?, ?> ColDate;

    @FXML
    private TableColumn<?, ?> ColDestinatiionTime;

    @FXML
    private TableColumn<?, ?> ColFlightNumber;

    @FXML
    private TableColumn<?, ?> ColFromCity;

    @FXML
    private TableColumn<?, ?> ColPlaneNumber;

    @FXML
    private TableColumn<?, ?> ColTicketPrice;

    @FXML
    private TableColumn<?, ?> ColToCity;

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
    private Button btnBook;

    @FXML
    private TextField flightNumberTF;

    @FXML
    private TextField planeNumberTF;

    @FXML
    private AnchorPane rootAnchorPane;

    PaneSwicher swicher = new PaneSwicher();

    @FXML
    void btnBussiSeeseatClicked(ActionEvent event) {

    }

    @FXML
    void btnEcoSeeseatClicked(ActionEvent event) {

    }

    @FXML
    void ButtonSearchClicked(ActionEvent event) {

    }

    private void addButtonToTable() {
        TableColumn<Data, Void> colBtn = new TableColumn("book Column");

        Callback<TableColumn<Data, Void>, TableCell<Data, Void>> cellFactory = new Callback<TableColumn<Data, Void>, TableCell<Data, Void>>() {
            @Override
            public TableCell<Data, Void> call(final TableColumn<Data, Void> param) {
                final TableCell<Data, Void> cell = new TableCell<Data, Void>() {

                    private final Button btn = new Button("book");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Data data = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + data);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        flightlistTable.getColumns().add(colBtn);

    }

}
