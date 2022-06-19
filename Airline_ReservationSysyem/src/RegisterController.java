import java.io.IOException;

import Utility.SceneSwitcher;
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
    private TextField EmailTextFild;

    @FXML
    private TextField FristNameTextFild;

    @FXML
    private TextField LastNameTextFild;

    @FXML
    private TextField PasswardTextFild;

    @FXML
    private TextField PhoneTextFild;

    @FXML
    private Button SignupButton;

    @FXML
    private TextField conforimTextFild;

    @FXML
    private AnchorPane rootAnchorpane;

    MainController mainController = new MainController();
    int confirm;
    User_Queries user_Queries = new User_Queries();

    @FXML
    void CancelButtonClicked(ActionEvent event) {
        try {
            AnchorPane signUP = FXMLLoader.load(getClass().getResource("UI/CommenUI/login.fxml"));
            rootAnchorpane.getChildren().setAll(signUP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void SignupButtonClicked(ActionEvent event) {
        if (FristNameTextFild.getText() != "" && LastNameTextFild.getText() != "" && EmailTextFild.getText() != ""
                && PhoneTextFild.getText() != ""
                && PasswardTextFild.getText() != "" && conforimTextFild.getText() != "") {
            if (PasswardTextFild.getText() == conforimTextFild.getText()) {
                confirm = user_Queries.AddUser(FristNameTextFild.getText(), LastNameTextFild.getText(),
                        EmailTextFild.getText(), PhoneTextFild.getText(), PasswardTextFild.getText(), "User");
            }

        }

    }
}