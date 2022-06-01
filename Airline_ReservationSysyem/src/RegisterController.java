import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RegisterController extends SceneSwitcher {

    @FXML
    private Button CancelButton;

    @FXML
    private TextField FristNameTextFild;

    @FXML
    private TextField LastNameTextFild;

    @FXML
    private TextField PasswardTextFild;

    @FXML
    private Button SignupButton;

    @FXML
    private TextField conforimTextFild;

    @FXML
    private TextField loginTextFild;

    @FXML
    private AnchorPane rootAnchorpane;

    MainController mainController = new MainController();

    @FXML
    void CancelButtonClicked(ActionEvent event) {
        try {
            AnchorPane signUP = FXMLLoader.load(getClass().getResource("UI/CommenUI/login.fxml"));
            rootAnchorpane.getChildren().setAll(signUP);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    void SignupButtonClicked(ActionEvent event) {
        try {
            AnchorPane signUP = FXMLLoader.load(getClass().getResource("UI/CommenUI/login.fxml"));
            rootAnchorpane.getChildren().setAll(signUP);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
