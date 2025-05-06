package jean.chess.model.game.pieces.pieces_type;

import jean.chess.model.game.pieces.Piece;
import jean.chess.model.game.pieces.Position;

import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(boolean isWhite, String icon) {
        super(isWhite, icon);
    }

    public Bishop(boolean isWhite, String pieceIconPath, int col, int row) {
        super(isWhite,pieceIconPath);
        this.setActual_position(new Position(col,row));
        this.updatePositionPossibleMoves();
    }

    @Override
    public void updatePositionPossibleMoves() {
        int actual_posX = this.getActualPosition().getPosX();
        int actual_posY = this.getActualPosition().getPosY();
        ArrayList<Position> positions_possible_moves = new ArrayList<>();

        int x = actual_posX;
        int y = actual_posY;
        while (x < 7 && y < 7 ){
            x++;
            y++;
            Position position = new Position(x,y);
            positions_possible_moves.add(position);
        }

        x = actual_posX;
        y = actual_posY;
        while (x > 0 && y > 0 ){
            x--;
            y--;
            Position position = new Position(x,y);
            positions_possible_moves.add(position);
        }

        x = actual_posX;
        y = actual_posY;
        while (x < 7 && y > 0 ){
            x++;
            y--;
            Position position = new Position(x,y);
            positions_possible_moves.add(position);
        }

        x = actual_posX;
        y = actual_posY;
        while (x > 0 && y < 7 ){
            x--;
            y++;
            Position position = new Position(x,y);
            positions_possible_moves.add(position);
        }

        this.setPositionsPossibleMoves(positions_possible_moves);



    }


}
