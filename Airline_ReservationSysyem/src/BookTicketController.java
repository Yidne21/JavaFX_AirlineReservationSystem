import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;

public class BookTicketController {

    @FXML
    private Button BtnECosee;

    @FXML
    private TilePane BusstilePane;

    @FXML
    private Button CancelButton;

    @FXML
    private TextField DateTextFild;

    @FXML
    private TilePane EcotilePane;

    @FXML
    private TextField EmailTextFild;

    @FXML
    private TextField NoOfPersonTextFild;

    @FXML
    private Button ProcessButton;

    @FXML
    private Button btnsee;

    @FXML
    private TextField flightNumberTF;

    @FXML
    private TextField planeNumberTF1;

    @FXML
    void BtnECoseeClicked(ActionEvent event) {
        for (int i = 0; i < 20; i++) {
            String text = String.valueOf(i);
            Button button = new Button(text);
            EcotilePane.getChildren().addAll(button);

        }

    }

    @FXML
    void ProcessButtonClicked(ActionEvent event) {

    }

    @FXML
    void ProcessButtonClicled(ActionEvent event) {

    }

    @FXML
    void btnseeClicked(ActionEvent event) {
        for (int i = 0; i < 10; i++) {
            String text = String.valueOf(i);
            Button button = new Button(text);
            BusstilePane.getChildren().addAll(button);
        }

    }

}
