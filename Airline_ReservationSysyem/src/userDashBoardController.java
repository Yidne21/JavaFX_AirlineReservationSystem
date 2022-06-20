
import java.io.IOException;

import Utility.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;

public class userDashBoardController extends SceneSwitcher {

    @FXML
    public Label LableName;

    @FXML
    public Button btnAvilableFlight;

    @FXML
    public Button btnLogout;

    @FXML
    public Button btnMyticket;

    @FXML
    public ImageView imageView;

    @FXML
    public BorderPane rootBorderpane;

    @FXML
    public VBox vbox;

    PaneSwicher swicher = new PaneSwicher();

    @FXML
    void btnAvilableFlightCliked(ActionEvent event) throws IOException {
        Pane view = swicher.getPane("UserUI/PassengerfligtList");
        rootBorderpane.setCenter(view);
    }

    @FXML
    void btnLogoutClicked(ActionEvent event) throws IOException {
        MainController mainController = new MainController();
        mainController.setIslogin(false);
        root = getScene("CommenUI/Main");
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnMyticketClicked(ActionEvent event) {
        Pane view = swicher.getPane("UserUI/MyTicket");
        rootBorderpane.setCenter(view);
    }

}
