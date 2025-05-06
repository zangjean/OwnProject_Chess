package jean.chess.utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public abstract class Others {

    public static void setNewRoot(ActionEvent actionEvent, String path) throws IOException {
        Node source = (Node) actionEvent.getSource();
        Scene currentScene = source.getScene();
        FXMLLoader loader = new FXMLLoader(Others.class.getResource(path));
        BorderPane gameView = loader.load();
        currentScene.setRoot(gameView);
    }
}
