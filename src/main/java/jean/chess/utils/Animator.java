package jean.chess.utils;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public abstract class Animator {

    public static void applyHoverEffectOnButton(Button button) {
        ScaleTransition scaleIn = new ScaleTransition(Duration.millis(150), button);
        scaleIn.setToX(1.1);
        scaleIn.setToY(1.1);

        ScaleTransition scaleOut = new ScaleTransition(Duration.millis(150), button);
        scaleOut.setToX(1.0);
        scaleOut.setToY(1.0);

        button.setOnMouseEntered(e -> scaleIn.playFromStart());
        button.setOnMouseExited(e -> scaleOut.playFromStart());
    }

    public static void animateTitle(Node title) {
        // Zoom léger
        ScaleTransition scale = new ScaleTransition(Duration.seconds(1), title);
        scale.setFromX(0.8);
        scale.setFromY(0.8);
        scale.setToX(1.0);
        scale.setToY(1.0);

        // Apparition en fondu
        FadeTransition fade = new FadeTransition(Duration.seconds(1), title);
        fade.setFromValue(0);
        fade.setToValue(1);

        scale.play();
        fade.play();
    }

    public static void animateLabelPulse(Label label,int secondes) {
        ScaleTransition pulse = new ScaleTransition(Duration.seconds(secondes), label);
        pulse.setFromX(1.5);
        pulse.setFromY(1.5);
        pulse.setToX(1.05);
        pulse.setToY(1.05);
        pulse.setAutoReverse(true);
        pulse.setCycleCount(Timeline.INDEFINITE);
        pulse.play();
    }
}