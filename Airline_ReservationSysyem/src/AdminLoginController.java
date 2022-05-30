import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class AdminLoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button LoginButton;

    @FXML
    private Label emailTF;

    @FXML
    private PasswordField passwordTF;

    @FXML
    void loginBtnClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("UI/AdminUI/AdminDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
