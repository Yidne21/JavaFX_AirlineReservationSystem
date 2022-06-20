import java.io.IOException;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;

import Utility.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Node;
import javafx.stage.Stage;
import model.DataAccessQueries;
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
    Boolean isvalidCreditCard = false;

    userDashBoardController userDB;
    PaneSwicher swicher = new PaneSwicher();
    DataAccessQueries dataAccessQueries = new DataAccessQueries();

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
    void btnPayClicked(ActionEvent event) throws IOException, SQLException {

        if (CVVNoTF.getText() != null && CardHolderTF.getText() != null && CVVNoTF.getText() != null
                && ExpaireDP.getValue() != null) {
            if (BookTicketController.getSuccess() == 1) {
                dataAccessQueries.UpdateSeat(BookTicketController.getSeatid(), "booked");
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.contentTextProperty().set("Ticket Booked seccessfully");
                alert.show();
                ;
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.contentTextProperty().set("Failed please try Again");
                alert.show();
                ;
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.contentTextProperty().set("please fill all field ");
            alert.show();
            ;
        }

    }

}
