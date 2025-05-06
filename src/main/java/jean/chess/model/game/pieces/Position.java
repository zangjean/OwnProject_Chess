package jean.chess.model.game.pieces;

import java.util.Objects;

public class Position {
    private int posX;
    private int posY;

    public Position(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        if(posX < 0 || posX > 7) {
            throw new IllegalArgumentException("ERROR: setPosX -> Position X must be between 0 and 7");
        }else{
            this.posX = posX;
        }
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        if(posY < 0 || posY > 7) {
            throw new IllegalArgumentException("ERROR: setPosY -> Position Y must be between 0 and 7");
        }else {
            this.posY = posY;
        }
    }

    @Override
    public String toString() {
        return "(" + posX + "," + posY + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return posX == position.posX && posY == position.posY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posX, posY);
    }

}
