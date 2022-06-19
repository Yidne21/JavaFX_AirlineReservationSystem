
import java.io.IOException;

import Utility.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController extends SceneSwitcher {
    @FXML
    public Button LoginButton;

    @FXML
    public Button btnSignUp;

    @FXML
    public AnchorPane rootAnchorPane;

    @FXML
    public ImageView imageView;
    @FXML
    private TextField emailTF;

    @FXML
    private PasswordField passwordTF;

    @FXML
    void btnSignUpClicked(ActionEvent event) throws IOException {
        PaneSwicher swicher = new PaneSwicher();
        Pane view = swicher.getPane("UserUI/Registration");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UI/CommenUI/Main.fxml"));
        Parent root = loader.load();
        MainController mainController = loader.getController();
        mainController.MainBorderpane.setCenter(view);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    int confirm;
    User_Queries user_Queries = new User_Queries();

    @FXML
    void loginBtnClicked(ActionEvent event) throws IOException {
<<<<<<< HEAD
        MainController mainController = new MainController();
        mainController.setIslogin(true);
        root = getScene("UserUI/userDashboard");
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
=======
        confirm = user_Queries.check(emailTF.getText(), passwordTF.getText());
        if (confirm == 1) {
            try {
                root = getScene("UserUI/userDashboard");
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
>>>>>>> 17014ff5b1e6c61fe08c4bfea01d2120dbbfba4e

    }
}
