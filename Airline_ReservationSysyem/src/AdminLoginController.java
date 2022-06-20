import java.io.IOException;
import java.sql.SQLException;

import Utility.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DataAccessQueries;
import javafx.scene.Node;
import javafx.scene.Parent;

public class AdminLoginController extends SceneSwitcher {

    @FXML
    private Button LoginButton;

    @FXML
    private TextField emailTF;

    @FXML
    private PasswordField passwordTF;

    @FXML
    private AnchorPane rootAnchorPane;

    int confirm;
    DataAccessQueries database = new DataAccessQueries();

    @FXML
    void loginBtnClicked(ActionEvent event) throws IOException, SQLException {
        confirm = database.check(emailTF.getText(), passwordTF.getText(), "Admin");
        if (confirm == 1) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("UI/AdminUI/AdminDashboard.fxml"));
                Parent root = loader.load();
                AdminDashbordController adminDashbordController = loader.getController();
                adminDashbordController.Namelable.setText(emailTF.getText());
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

}
