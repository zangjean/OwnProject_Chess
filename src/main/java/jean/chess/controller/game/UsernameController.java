package jean.chess.controller.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import jean.chess.model.game.Game;
import jean.chess.utils.Animator;
import jean.chess.utils.GameState;
import jean.chess.utils.Others;

import java.io.IOException;

public class UsernameController {
    @FXML
    public Label error_message;
    @FXML
    public TextField white_username;
    @FXML
    public TextField black_username;
    @FXML
    private Button start;
    @FXML
    private Button back;

    @FXML
    public void initialize() {
        Animator.applyHoverEffectOnButton(start);
        Animator.applyHoverEffectOnButton(back);
    }

    public void start(ActionEvent actionEvent) {
        if(white_username.getText().isEmpty()||black_username.getText().isEmpty()) {
            error_message.setText("ERROR: White or Black Username is empty");
            error_message.setStyle("-fx-text-fill: red");
        }else{
            error_message.setText("");
            try {
                GameState.initGame(this.white_username.getText(),this.black_username.getText());
                Others.setNewRoot(actionEvent,"/jean/chess/view/game/game.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void back(ActionEvent actionEvent) {
        try {
            Others.setNewRoot(actionEvent,"/jean/chess/view/home_page/home_page.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
