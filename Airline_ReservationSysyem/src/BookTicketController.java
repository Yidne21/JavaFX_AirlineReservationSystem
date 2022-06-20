import java.io.IOException;
import java.sql.SQLException;

import Utility.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.Node;
import javafx.stage.Stage;
import model.DataAccessQueries;
import model.seat;

public class BookTicketController extends SceneSwitcher {

    @FXML
    public Button BtnECosee;

    @FXML
    public Button CancelButton;

    @FXML
    public TextField seatNumber;

    @FXML
    public ListView<seat> EcoLV;

    @FXML
    public TextField EmailTextFild;

    @FXML
    public Button ProcessButton;

    @FXML
    public Button btnsee;

    @FXML
    public ListView<seat> busLV;

    @FXML
    public TextField TicketnumberTF;
    DataAccessQueries dataAccessQueries = new DataAccessQueries();
    public static int success;
    public static int ticketid, seatid;

    @FXML
    void BtnECoseeClicked(ActionEvent event) {
        ObservableList<seat> data = FXCollections.observableArrayList();
        data.addAll(dataAccessQueries.getEcoSeat());
        EcoLV.setItems(data);

    }

    userDashBoardController userDB;
    PaneSwicher swicher = new PaneSwicher();

    @FXML
    void ProcessButtonClicked(ActionEvent event) throws IOException, SQLException {
        DataAccessQueries dataAccessQueries = new DataAccessQueries();
        ticketid = Integer.parseInt(TicketnumberTF.getText());
        seatid = Integer.parseInt(seatNumber.getText());
        setSeatid(seatid);
        BookTicketController.success = dataAccessQueries.inserIntoBook(ticketid, EmailTextFild.getText(), seatid);
        setSuccess(success);
        System.out.println(success);
        System.out.println(getSuccess());
        if (success == 1) {
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

    @FXML
    void CancelButtonClicked(ActionEvent event) throws IOException {
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
    void btnseeClicked(ActionEvent event) {
        ObservableList<seat> data = FXCollections.observableArrayList();
        data.addAll(dataAccessQueries.getBessiSeat());
        busLV.setItems(data);
    }

    public void setFlightNumberTF(String TicketnumberTF) {
        this.TicketnumberTF.setText(TicketnumberTF);
    }

    public static int getSuccess() {
        return success;
    }

    public static void setSuccess(int success) {
        BookTicketController.success = success;
    }

    public static void setSeatid(int seatid) {
        BookTicketController.seatid = seatid;
    }

    public static int getSeatid() {
        return seatid;
    }

}
