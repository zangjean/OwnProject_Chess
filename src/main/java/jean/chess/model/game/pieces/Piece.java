package jean.chess.model.game.pieces;

import java.util.ArrayList;

public abstract class Piece {

    private boolean isWhite;
    private String icon;
    private Position actual_position;
    private ArrayList<Position> positions_possible_moves ;
    private boolean already_moved;

    public Piece(boolean isWhite, String icon){
        this.isWhite = isWhite;
        this.icon = icon;
        this.positions_possible_moves = new ArrayList<>();
        this.already_moved = false;
    }

    public ArrayList<Position> getPositions_possible_moves() {
        return positions_possible_moves;
    }

    public void setPositionsPossibleMoves(ArrayList<Position> positions_possible_moves) {
        this.positions_possible_moves = positions_possible_moves;
    }

    public Position getActualPosition() {
        return actual_position;
    }

    public void setActual_position(Position actual_position) {
        this.actual_position = actual_position;
    }

    public String getIcon_path() {
        return icon;
    }

    @Override
    public String toString() {
        return (isWhite ? "W" : "B") + "_" + this.getClass().getSimpleName();
    }

    public void printPiece(){
        System.out.print(this.toString());
    }

    public String toStringPositionPossibleMoves() {
        String possible_moves = "";
        for (Position position : positions_possible_moves) {
            possible_moves += position.toString() + " ";
        }
        return possible_moves;
    }
    public boolean isWhite() {
        return isWhite;
    }

    public void movePiece(Position new_position){
        this.setAlready_moved(true);
        if(this.positions_possible_moves.contains(new_position)){
            this.actual_position = new_position;
            this.updatePositionPossibleMoves();
        }else {
            throw new IllegalArgumentException("ERROR: movePiece -> Position " + new_position.toString() + " is not possible for this piece");
        }
    }

    public abstract void updatePositionPossibleMoves();

    public boolean isAlready_moved() {
        return already_moved;
    }

    public void setAlready_moved(boolean already_moved) {
        this.already_moved = already_moved;
    }

    public ArrayList<Position> getPositionPossibleMoves(){
        this.updatePositionPossibleMoves();
         return this.positions_possible_moves;
    }
}
