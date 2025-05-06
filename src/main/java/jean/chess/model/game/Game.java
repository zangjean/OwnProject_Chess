package jean.chess.model.game;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import jean.chess.model.game.pieces.Piece;

public class Game {
    private Player whitePlayer ;
    private Player blackPlayer ;
    private Board board;
    private boolean is_game_over;
    private boolean is_white_turn;
    private SimpleBooleanProperty is_white_turn_property;


    public Game(String playerWhiteName, String playerBlackName) {
        this.blackPlayer = new Player(playerBlackName,false);
        this.whitePlayer = new Player(playerWhiteName,true);
        this.board = new Board(this.whitePlayer,this.blackPlayer);
        this.is_game_over = false;
        this.is_white_turn = true;
        this.is_white_turn_property = new SimpleBooleanProperty(this.is_white_turn);


    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }
    public Player getBlackPlayer() {
        return blackPlayer;
    }
    public Board getBoard() {
        return board;
    }
    public boolean isGameOver() {
        return is_game_over;
    }
    public boolean isWhiteTurn() {
        return is_white_turn;
    }
    public void changeTurn() {
        this.is_white_turn = !this.is_white_turn;
        this.is_white_turn_property.set(this.is_white_turn);
    }
    public boolean isBlackTurn() {
        return !this.is_white_turn;
    }

    public boolean isIs_white_turn_property() {
        return is_white_turn_property.get();
    }

    public SimpleBooleanProperty getIs_white_turn_propertyProperty() {
        return is_white_turn_property;
    }

    public void setIs_white_turn_property(boolean is_white_turn_property) {
        this.is_white_turn_property.set(is_white_turn_property);
    }

    public boolean isPositionOccupied(int row,int col){
        //return this.board.isPositionOccupied(row,col);
        return this.board.isPositionOccupied(col,row);
    }

    public String getPieceIconPathAtPosition(int row,int col){
        return this.board.getPieceIconPathAtPosition(col,row);
    }

    public Piece getPieceAtPosition(int row, int col) {
        return this.board.getPieceAtPosition(col,row);
    }
}
