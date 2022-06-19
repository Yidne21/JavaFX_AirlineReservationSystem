import java.io.IOException;

import Utility.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class AdminFlightList extends SceneSwitcher {

    @FXML
    private TableColumn<?, ?> airpotNameColumn;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private Button deleteButton;

    @FXML
    private TableColumn<?, ?> editColumn;

    @FXML
    private TableColumn<?, ?> flightNameColumn;

    @FXML
    private TableColumn<?, ?> fromCityColumn;

    @FXML
    private Button newButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchByFlightNo;

    @FXML
    private TextField searchByName;

    @FXML
    private TableColumn<?, ?> ticketPriceColumn;

    @FXML
    private TableColumn<?, ?> timeColumn;

    @FXML
    private TableColumn<?, ?> toCityColumn;

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

    }

    @FXML
    void deletBtnCliked(ActionEvent event) {

    }

}
