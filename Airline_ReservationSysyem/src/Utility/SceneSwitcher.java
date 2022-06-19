package Utility;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneSwitcher {
    public Stage stage;
    public Scene scene;
    public Parent root;

    public Parent getScene(String path) throws IOException {
        root = FXMLLoader.load(getClass().getResource("UI/" + path + ".fxml"));
        return root;
    }

}
