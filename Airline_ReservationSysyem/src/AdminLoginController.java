import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class AdminLoginController extends SceneSwitcher {

    @FXML
    private Button LoginButton;

    @FXML
    private Label emailTF;

    @FXML
    private PasswordField passwordTF;

    @FXML
    void loginBtnClicked(ActionEvent event) throws IOException {
        root = getScene("AdminUI/AdminDashboard");
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
