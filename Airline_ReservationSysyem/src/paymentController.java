import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import Utility.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class paymentController extends SceneSwitcher {

    @FXML
    private TextField CVVNoTF;

    @FXML
    private TextField CardHolderTF;

    @FXML
    private TextField CardNumberTF;

    @FXML
    private DatePicker ExpaireDP;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnPay;

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
    void btnPayClicked(ActionEvent event) {

    }

}
