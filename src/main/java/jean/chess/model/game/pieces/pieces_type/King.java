package jean.chess.model.game.pieces.pieces_type;

import jean.chess.model.game.pieces.Piece;
import jean.chess.model.game.pieces.Position;

import java.util.ArrayList;

public class King extends Piece {
    public King(boolean isWhite, String pieceIconPath, int col, int row) {
        super(isWhite,pieceIconPath);
        this.setActual_position(new Position(col,row));
        this.updatePositionPossibleMoves();
    }

    @Override
    public void updatePositionPossibleMoves() {
        int actual_posX = this.getActualPosition().getPosX();
        int actual_posY = this.getActualPosition().getPosY();
        ArrayList<Position> positions_possible_moves = new ArrayList<>();

        //il se deplace en croix de 1
        if(actual_posX+1 <= 7){
            positions_possible_moves.add(new Position(actual_posX+1,actual_posY));
        }
        if(actual_posX-1 >= 0){
            positions_possible_moves.add(new Position(actual_posX-1,actual_posY));
        }
        if(actual_posY+1 <= 7){
            positions_possible_moves.add(new Position(actual_posX,actual_posY+1));
        }
        if(actual_posY-1 >= 0){
            positions_possible_moves.add(new Position(actual_posX,actual_posY-1));
        }

        this.setPositionsPossibleMoves(positions_possible_moves);



    }
}
