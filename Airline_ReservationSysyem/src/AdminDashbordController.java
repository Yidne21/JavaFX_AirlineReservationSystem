import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminDashbordController extends SceneSwitcher {

    @FXML
    public Button btnBookedTicketList;

    @FXML
    public Button btnEditProfile;

    @FXML
    public Button btnLogout;

    @FXML
    public Button btnSchedulFlight;

    @FXML
    public BorderPane rootBorderpane;

    PaneSwicher swicher = new PaneSwicher();

    @FXML
    void btnBookedTicketListClicked(ActionEvent event) {
        Pane view = swicher.getPane("AdminUI/BookedTicketList");
        rootBorderpane.setCenter(view);
    }

    @FXML
    void btnEditProfileCliked(ActionEvent event) {

    }

    @FXML
    void btnLogoutClicked(ActionEvent event) {
        try {
            root = getScene("CommenUI/Main");
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void btnSchedulFlightCliked(ActionEvent event) {
        Pane view = swicher.getPane("AdminUI/ScheduleFlight");
        rootBorderpane.setCenter(view);
    }

}
