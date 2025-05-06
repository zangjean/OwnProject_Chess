package jean.chess.model.game;

import jean.chess.model.game.pieces.Piece;
import jean.chess.model.game.pieces.pieces_type.*;

import java.util.ArrayList;
import java.util.Locale;

public class Player {
    private String username;
    private boolean isWhite;
    private ArrayList<Piece> alivePieces;
    private ArrayList<Piece> deathPieces;

    public Player(String username,Boolean white) {
        this.username = username;
        this.isWhite = white;
        this.alivePieces = new ArrayList<>();
        this.deathPieces = new ArrayList<>();
        initAlivePieces();
    }

    private void initAlivePieces(){
        int row=0;
        if(this.isWhite){
            row=7;
        }
        this.alivePieces.add(new Rook(this.isWhite,getPieceIconPath(Rook.class).toLowerCase(),0,row));
        this.alivePieces.add(new Knight(this.isWhite,getPieceIconPath(Knight.class).toLowerCase(),1,row));
        this.alivePieces.add(new Bishop(this.isWhite,getPieceIconPath(Bishop.class).toLowerCase(),2,row));
        this.alivePieces.add(new Queen(this.isWhite,getPieceIconPath(Queen.class).toLowerCase(),3,row));
        this.alivePieces.add(new King(this.isWhite,getPieceIconPath(King.class).toLowerCase(),4,row));
        this.alivePieces.add(new Bishop(this.isWhite,getPieceIconPath(Bishop.class).toLowerCase(),5,row));
        this.alivePieces.add(new Knight(this.isWhite,getPieceIconPath(Knight.class).toLowerCase(),6,row));
        this.alivePieces.add(new Rook(this.isWhite,getPieceIconPath(Rook.class).toLowerCase(),7,row));

        initAllPawn();

    }

    private void initAllPawn(){
        int row=1;
        if(isWhite){
            row = 6;
        }

        for(int col=0;col<8;col++){
            this.alivePieces.add(new Pawn(this.isWhite,getPieceIconPath(Pawn.class).toLowerCase(),col,row));
        }
    }

    public String getUsername() {
        return username;
    }
    public boolean isWhite() {
        return isWhite;
    }
    public ArrayList<Piece> getAlivePieces() {
        return alivePieces;
    }
    public ArrayList<Piece> getDeathPieces() {
        return deathPieces;
    }
    public void addDeathPiece(Piece piece) {
        if(piece.isWhite() == this.isWhite){
            this.deathPieces.add(piece);
        }else {
            throw new IllegalArgumentException("ERROR: addDeathPiece -> Piece color doesn't match with player color");
        }
    }
    public void addAlivePiece(Piece piece) {
        if(piece.isWhite() == this.isWhite){
            this.alivePieces.add(piece);
        }else {
            throw new IllegalArgumentException("ERROR: addAlivePiece -> Piece color doesn't match with player color");
        }
    }

    public void killPiece(Piece piece){
        if(this.alivePieces.contains(piece)){
            this.alivePieces.remove(piece);
            this.deathPieces.add(piece);
        }
    }

    private String getPieceIconPath(Class<? extends Piece> pieceClass){
        String iconPath = "/jean/chess/images/pieces";
        if(this.isWhite){
            iconPath = iconPath + "/white/white_";
        }else {
            iconPath = iconPath + "/black/black_";
        }
        iconPath = iconPath + pieceClass.getSimpleName() + ".png";
        System.out.println("ICON PATH = "+iconPath);
        return iconPath;
    }






}
