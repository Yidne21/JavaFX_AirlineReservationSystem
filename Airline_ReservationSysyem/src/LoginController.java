import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class LoginController extends SceneSwitcher {
    @FXML
    private Button LoginButton;

    @FXML
    private AnchorPane rootAnchorPane;

    @FXML
    private ImageView imageView;

    @FXML
    void loginBtnClicked(ActionEvent event) {
        try {
            root = getScene("UserUI/userDashboard");
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
