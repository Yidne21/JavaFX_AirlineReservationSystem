import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MainController {

    @FXML
    private Button ButtonFlight;

    @FXML
    private Button ButtonHome;

    @FXML
    private Button ButtonLogin;

    @FXML
    private Button ButtonSignUp;

    @FXML
    private Button BtnAdmin;

    @FXML
    private BorderPane MainBorderpane;

    @FXML
    void ButtonFlihtClicked(ActionEvent event) {
        PaneSwicher swicher = new PaneSwicher();
        Pane view = swicher.getPane("PassengerfligtList");
        MainBorderpane.setCenter(view);

    }

    @FXML
    void ButtonHomeClicked(ActionEvent event) {
        PaneSwicher swicher = new PaneSwicher();
        Pane view = swicher.getPane("HomePage");
        MainBorderpane.setCenter(view);

    }

    @FXML
    void ButtonLoginCliked(ActionEvent event) {
        PaneSwicher swicher = new PaneSwicher();
        Pane view = swicher.getPane("login");
        MainBorderpane.setCenter(view);

    }

    @FXML
    void btnAdminClicked(ActionEvent event) {
        PaneSwicher swicher = new PaneSwicher();
        Pane view = swicher.getPane("login");
        MainBorderpane.setCenter(view);

    }

}
