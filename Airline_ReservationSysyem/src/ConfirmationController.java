
import java.io.IOException;

import Utility.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.Node;
import javafx.stage.Stage;

public class ConfirmationController extends SceneSwitcher {

    @FXML
    private Label LableArrivalTime;

    @FXML
    private Label Lableflightname;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnConfirm;

    @FXML
    private Label labelFlightID;

    @FXML
    private Label lableDate;

    @FXML
    private Label lablePrice;

    @FXML
    private Label lableSeatNumber;
    userDashBoardController userDB;
    PaneSwicher swicher = new PaneSwicher();

    @FXML
    void btnCancelClicked(ActionEvent event) throws IOException {
        Pane view = swicher.getPane("UserUI/PassengerfligtList");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UI/UserUI/userDashboard.fxml"));
        Parent root = loader.load();
        userDB = new userDashBoardController();
        userDB = loader.getController();
        userDB.rootBorderpane.setCenter(view);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnConfirmClicked(ActionEvent event) throws IOException {
        swicher = new PaneSwicher();
        Pane view = swicher.getPane("UserUI/payment");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UI/UserUI/userDashboard.fxml"));
        Parent root = loader.load();
        userDB = new userDashBoardController();
        userDB = loader.getController();
        userDB.rootBorderpane.setCenter(view);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
