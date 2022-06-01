import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class userDashBoardController extends SceneSwitcher {

    @FXML
    private Label LableName;

    @FXML
    private Button btnAvilableFlight;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnMyticket;

    @FXML
    private ImageView imageView;

    @FXML
    private BorderPane rootBorderpane;

    PaneSwicher swicher = new PaneSwicher();

    @FXML
    void btnAvilableFlightCliked(ActionEvent event) throws IOException {
        Pane view = swicher.getPane("UserUI/PassengerfligtList");
        rootBorderpane.setCenter(view);
    }

    @FXML
    void btnLogoutClicked(ActionEvent event) throws IOException {
        root = getScene("CommenUI/Main");
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnMyticketClicked(ActionEvent event) {
        Pane view = swicher.getPane("UserUI/MyTicketList");
        rootBorderpane.setCenter(view);
    }

}
