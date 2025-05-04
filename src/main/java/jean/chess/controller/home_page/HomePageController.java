package jean.chess.controller.home_page;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import jean.chess.utils.ButtonAnimator;

public class HomePageController {

    @FXML
    private Button nouvelle_partie;
    @FXML
    private Button quitter;
    @FXML
    private Button options;

    @FXML
    public void initialize() {
        ButtonAnimator.applyHoverEffect(nouvelle_partie);
        ButtonAnimator.applyHoverEffect(quitter);
        ButtonAnimator.applyHoverEffect(options);
    }
}
