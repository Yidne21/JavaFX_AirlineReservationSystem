
import javafx.application.Application;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage; // connect primary stage
        mainWindow();
    }

    // main window
    public void mainWindow() {
        try {
            // view
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/UI/CommenUI/Main.fxml"));
            AnchorPane pane = loader.load();

            // controller
            MainController mainController = loader.getController();
            mainController.setMain(this);

            // scene on stage
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
