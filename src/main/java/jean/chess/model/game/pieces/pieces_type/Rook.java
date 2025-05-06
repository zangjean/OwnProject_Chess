package jean.chess.model.game.pieces.pieces_type;

import jean.chess.model.game.pieces.Piece;
import jean.chess.model.game.pieces.Position;

import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(boolean isWhite, String icon) {
        super(isWhite, icon);
    }

    public Rook(boolean isWhite,String pieceIconPath, int col, int row) {
        super(isWhite,pieceIconPath);
        this.setActual_position(new Position(col,row));
        this.updatePositionPossibleMoves();
    }

    @Override
    public void updatePositionPossibleMoves() {
        int actual_posX = this.getActualPosition().getPosX();
        int actual_posY = this.getActualPosition().getPosY();
        ArrayList<Position> positions_possible_moves = new ArrayList<>();

        for(int x = actual_posX ; x <= 7 ; x++){
            Position position = new Position(x,actual_posY);
            positions_possible_moves.add(position);
        }
        for(int x = actual_posX ; x >= 0 ; x--){
            Position position = new Position(x,actual_posY);
            positions_possible_moves.add(position);
        }
        for (int y = actual_posY ; y <= 7 ; y++){
            Position position = new Position(actual_posX,y);
            positions_possible_moves.add(position);
        }
        for (int y = actual_posY ; y >= 0 ; y--){
            Position position = new Position(actual_posX,y);
            positions_possible_moves.add(position);
        }

        this.setPositionsPossibleMoves(positions_possible_moves);

    }
}
