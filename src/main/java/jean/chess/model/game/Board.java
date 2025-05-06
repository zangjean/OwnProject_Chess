package jean.chess.model.game;

import jean.chess.model.game.pieces.Piece;

public class Board {
    private Piece[][] board;

    public Board(Player  whitePlayer, Player blackPlayer) {
        this.board = new Piece[8][8];
        initBoard(whitePlayer,blackPlayer);

    }

    public Piece[][] getBoard() {
        return board;
    }

    private void initBoard(Player whitePlayer, Player blackPlayer){
        for(Piece whitePlayerPiece : whitePlayer.getAlivePieces()){
            board[whitePlayerPiece.getActualPosition().getPosX()][whitePlayerPiece.getActualPosition().getPosY()]=whitePlayerPiece;
        }

        for(Piece blackPlayerPiece : blackPlayer.getAlivePieces()){
            board[blackPlayerPiece.getActualPosition().getPosX()][blackPlayerPiece.getActualPosition().getPosY()]=blackPlayerPiece;
        }

    }

    public void printBoard(){
        for(int x=0;x<8;x++){
            System.out.println("----------------------------------------------------------------------------");
            for(int y=0;y<8;y++){
                System.out.print("| ");
                if(this.board[y][x] == null){
                    System.out.print("      ");
                }else{
                    this.board[y][x].printPiece();
                }
                System.out.print(" |");
            }
            System.out.print("\n");
        }
    }

    public String getPieceIconPathAtPosition(int x, int y){
        String pieceIconPath = "";
        Piece piece = this.board[x][y];
        if(piece != null){
            pieceIconPath=pieceIconPath+piece.getIcon_path();
        }
        return pieceIconPath;
    }

    public Piece getPieceAtPosition(int x, int y){
        return this.board[x][y];
    }

    public void setPieceAtPosition(Piece piece, int x, int y){
        this.board[x][y]=piece;
    }

    private void removePieceAtPosition(int x, int y){
        this.board[x][y]=null;
    }

    private boolean isPositionEmpty(int x, int y){
        return this.board[x][y]==null;
    }

    public boolean isPositionOccupied(int x, int y){
        return this.board[x][y]!=null;
    }

    private boolean isPositionOccupiedByPlayer(int x, int y, Player player){
        boolean isOccupied = false;
        Piece piece = this.board[x][y];
        if(piece != null){
            isOccupied = piece.isWhite() == player.isWhite();
        }
        return isOccupied;
    }
}
