module jean.chess {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    // Ouvre tous les packages nécessaires aux fichiers FXML
    opens jean.chess to javafx.fxml;
    opens jean.chess.controller.home_page to javafx.fxml;
    opens jean.chess.controller.game to javafx.fxml;
    opens jean.chess.model.home_page to javafx.fxml;
    opens jean.chess.model.game to javafx.fxml;

    exports jean.chess;
    exports jean.chess.controller.home_page;
    exports jean.chess.controller.game;
    exports jean.chess.model.home_page;
    exports jean.chess.model.game;
    exports jean.chess.utils;
    exports jean.chess.model.game.pieces.pieces_type;
    exports jean.chess.model.game.pieces;

}
