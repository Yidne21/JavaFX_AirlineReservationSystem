import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;

public class LoginController implements Initializable {
    @FXML
    private Button LoginButton;

    @FXML
    private Button signupBtn;

    private Stage stage;
    private Scene scene;
    private Parent root;

    MainController mainController = new MainController();

    @FXML
    void SignUpclicked(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("UI/CommenUI/Registration.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void loginBtnClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("UI/UserUI/userDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }

}
