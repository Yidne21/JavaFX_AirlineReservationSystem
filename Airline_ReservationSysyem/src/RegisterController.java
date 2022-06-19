
import java.io.IOException;

import Utility.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.Node;
import javafx.stage.Stage;

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

    @FXML
    void CancelButtonClicked(ActionEvent event) throws IOException {
        PaneSwicher swicher = new PaneSwicher();
        Pane view = swicher.getPane("CommenUI/login");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UI/CommenUI/Main.fxml"));
        Parent root = loader.load();
        MainController mainController = loader.getController();
        mainController.MainBorderpane.setCenter(view);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void SignupButtonClicked(ActionEvent event) throws IOException {
        PaneSwicher swicher = new PaneSwicher();
        Pane view = swicher.getPane("CommenUI/login");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UI/CommenUI/Main.fxml"));
        Parent root = loader.load();
        MainController mainController = loader.getController();
        mainController.MainBorderpane.setCenter(view);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
