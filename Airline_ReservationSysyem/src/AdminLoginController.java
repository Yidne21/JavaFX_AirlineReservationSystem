<<<<<<< HEAD
import java.io.IOException;
import java.sql.SQLException;

import Utility.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DataAccessQueries;
import javafx.scene.Node;

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
                root = getScene("AdminUI/AdminDashboard");
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
=======
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;

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
    void loginBtnClicked(ActionEvent event) throws IOException {
        confirm = database.check(emailTF.getText(), passwordTF.getText(), "Admin");
        if (confirm == 1) {
            try {
                root = getScene("AdminUI/AdminDashboard");
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
>>>>>>> 1430c61ce5ae4df9cee3345f6d9895624fc866d0
