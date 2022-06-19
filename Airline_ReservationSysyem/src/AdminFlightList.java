import java.io.IOException;
<<<<<<< HEAD

import Utility.SceneSwitcher;
=======
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
>>>>>>> 17014ff5b1e6c61fe08c4bfea01d2120dbbfba4e
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.Node;
import javafx.stage.Stage;
import model.DataAccessQueries;
import model.adminFlightList;
import javafx.scene.Scene;

public class AdminFlightList extends SceneSwitcher implements Initializable {

    @FXML
    private TableColumn<adminFlightList, String> dateColumn;

    @FXML
    private Button deleteButton;

    @FXML
    private TableColumn<adminFlightList, String> editColumn;

    @FXML
    private TableColumn<adminFlightList, String> flightNameColumn;

    @FXML
    private TableColumn<adminFlightList, Integer> flightNoColumn;

    @FXML
    private TableColumn<adminFlightList, String> fromCityColumn;

    @FXML
    private Button newButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchByFlightNo;

    @FXML
    private TextField searchByCity;

    @FXML
    private TableView<adminFlightList> tbview;

    @FXML
    private TableColumn<adminFlightList, Integer> ticketPriceColumn;

    @FXML
    private TableColumn<adminFlightList, String> timeColumn;

    @FXML
    private TableColumn<adminFlightList, String> toCityColumn;

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
    void SearchBtnClicked(ActionEvent event) {
        if (searchByCity.getText()!= null) {
        f.setAll(dq.getByCity(searchByCity.getText()));
        }
        else if(searchByFlightNo.getText()!= null) {
            f.setAll(dq.getByFlightNumber(Integer.valueOf(searchByFlightNo.getText())));
    }
    }
    @FXML
    void deletBtnCliked(ActionEvent event) {
        tbview.getItems().removeAll(tbview.getSelectionModel().getSelectedItems());
        dq.deleteByid(1);
    }

    DataAccessQueries dq = new DataAccessQueries();
    ObservableList<adminFlightList> f = FXCollections.observableArrayList();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        f.setAll(dq.getFlight());


        flightNoColumn.setCellValueFactory(new PropertyValueFactory<adminFlightList,
        Integer>("schedule_id"));
        fromCityColumn.setCellValueFactory(new PropertyValueFactory<adminFlightList,
        String>("from"));
        toCityColumn.setCellValueFactory(new PropertyValueFactory<adminFlightList,
        String>("destination"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<adminFlightList,
        String>("date"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<adminFlightList,
        String>("departure_time"));
        ticketPriceColumn.setCellValueFactory(new
        PropertyValueFactory<adminFlightList, Integer>("ticket_price"));

        tbview.setItems(f);

    }

}
