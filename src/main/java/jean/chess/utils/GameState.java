package jean.chess.utils;

import jean.chess.model.game.Game;

public abstract class GameState {
    public static Game game;

    public static void initGame(String whitePlayerName, String blackPlayerName) {
        game = new Game(whitePlayerName,blackPlayerName);
    }
}
