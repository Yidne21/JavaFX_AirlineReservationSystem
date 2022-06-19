import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MainController extends LoginController {

    @FXML
    public Button ButtonFlight;

    @FXML
    public Button ButtonHome;

    @FXML
    public Button ButtonLogin;

    @FXML
    public Button ButtonSignUp;

    @FXML
    public Button BtnAdmin;

    @FXML
    public BorderPane MainBorderpane;

<<<<<<< HEAD
    public static Boolean islogin = false;

    public Boolean getIslogin() {
        return islogin;
    }

    public void setIslogin(Boolean islogin) {
        MainController.islogin = islogin;
    }

    private App main;
=======
    // private App main;
>>>>>>> 17014ff5b1e6c61fe08c4bfea01d2120dbbfba4e

    // // connect main class to controller
    // public void setMain(App main) {
    //     this.main = main;
    // }

    @FXML
    void ButtonFlihtClicked(ActionEvent event) throws IOException {
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
    void btnAdminClicked(ActionEvent event) throws IOException {
        PaneSwicher swicher = new PaneSwicher();
        Pane view = swicher.getPane("AdminUI/login");
        MainBorderpane.setCenter(view);

    }
}
