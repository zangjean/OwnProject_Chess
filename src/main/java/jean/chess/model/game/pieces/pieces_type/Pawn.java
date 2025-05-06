package jean.chess.model.game.pieces.pieces_type;

import jean.chess.model.game.pieces.Piece;
import jean.chess.model.game.pieces.Position;

import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn(boolean isWhite, String pieceIconPath, int col, int row) {
        super(isWhite,pieceIconPath);
        this.setActual_position(new Position(col,row));
        this.updatePositionPossibleMoves();
    }

    @Override
    public void updatePositionPossibleMoves() {
        int actual_posX = this.getActualPosition().getPosX();
        int actual_posY = this.getActualPosition().getPosY();
        ArrayList<Position> positions_possible_moves = new ArrayList<>();

        if(this.isWhite()){
            if(actual_posY-1>0){
                positions_possible_moves.add(new Position(actual_posX,actual_posY-1));
            }
            if(this.isAlready_moved() == false){
                positions_possible_moves.add(new Position(actual_posX,actual_posY-2));
            }
        }else {
            if(actual_posY+1<7){
                positions_possible_moves.add(new Position(actual_posX,actual_posY+1));
            }
            if(this.isAlready_moved() == false){
                positions_possible_moves.add(new Position(actual_posX,actual_posY+2));
            }
        }
        this.setPositionsPossibleMoves(positions_possible_moves);
    }
}
