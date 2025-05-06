package jean.chess.controller.home_page;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import jean.chess.utils.Animator;
import jean.chess.utils.Others;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class HomePageController {

    @FXML
    private Label title;
    @FXML
    private Button new_game;
    @FXML
    private Button quit;
    @FXML
    private Button options;

    @FXML
    public void initialize() {
        Animator.applyHoverEffectOnButton(new_game);
        Animator.applyHoverEffectOnButton(quit);
        Animator.applyHoverEffectOnButton(options);
        //Animator.animateTitle(title);
        Animator.animateLabelPulse(title,3);
    }

    @FXML
    public void quit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void new_game(ActionEvent actionEvent){
        try {
            Others.setNewRoot(actionEvent,"/jean/chess/view/game/username.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
