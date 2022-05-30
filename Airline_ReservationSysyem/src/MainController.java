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
    protected BorderPane MainBorderpane;

    @FXML
    void ButtonFlihtClicked(ActionEvent event) {
        PaneSwicher swicher = new PaneSwicher();
        Pane view = swicher.getPane("UserUI/PassengerfligtList");
        MainBorderpane.setCenter(view);

    }

    @FXML
    void ButtonHomeClicked(ActionEvent event) {
        PaneSwicher swicher = new PaneSwicher();
        Pane view = swicher.getPane("CommenUI/HomePage");
        MainBorderpane.setCenter(view);

    }

    @FXML
    void ButtonLoginCliked(ActionEvent event) {
        PaneSwicher swicher = new PaneSwicher();
        Pane view = swicher.getPane("CommenUI/login");
        MainBorderpane.setCenter(view);

    }

    @FXML
    void btnAdminClicked(ActionEvent event) {
        PaneSwicher swicher = new PaneSwicher();
        Pane view = swicher.getPane("AdminUI/login");
        MainBorderpane.setCenter(view);
    }
}
