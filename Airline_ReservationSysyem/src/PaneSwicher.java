
import java.io.InputStream;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class PaneSwicher {
    private Pane view;

    public Pane getPane(String PaneName) {

        try {
            InputStream fileUrl = App.class.getResourceAsStream("UI/" + PaneName +
                    ".fxml");
            if (fileUrl == null) {
                throw new java.io.FileNotFoundException(" not found");

            }

            view = new FXMLLoader().load(fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

}
