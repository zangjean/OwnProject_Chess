package jean.chess.controller.game;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import jean.chess.model.game.pieces.Position;
import jean.chess.utils.Animator;
import jean.chess.utils.GameState;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class GameController {

    @FXML
    public Label black_player_name;
    @FXML
    public Label white_player_name;
    @FXML
    public Button end_turn;
    @FXML
    public GridPane chessboard;

    private Node last_clicked_square;
    private ArrayList<Position> last_clicked_square_possible_moves;

    @FXML
    public void initialize() {
        Animator.applyHoverEffectOnButton(this.end_turn);
        this.black_player_name.setText(GameState.game.getBlackPlayer().getUsername());
        this.white_player_name.setText(GameState.game.getWhitePlayer().getUsername());
        this.white_player_name.getStyleClass().add("label-with-border");
        initLabelsNamesBindings();
        initChessboard();


    }

    private void initLabelsNamesBindings() {
        GameState.game.getIs_white_turn_propertyProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                this.white_player_name.getStyleClass().add("label-with-border");
                this.black_player_name.getStyleClass().remove("label-with-border");
            } else {
                this.black_player_name.getStyleClass().add("label-with-border");
                this.white_player_name.getStyleClass().remove("label-with-border");
            }
        });

    }

    public void endTurn(ActionEvent actionEvent) {
        GameState.game.changeTurn();


    }

    private void initChessboard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                StackPane square = new StackPane();

                // Applique la classe "white" ou "black" en alternant les couleurs
                if ((row + col) % 2 == 0) {
                    square.getStyleClass().add("white");
                } else {
                    square.getStyleClass().add("black");
                }

                square.getStyleClass().add("square"); // Style commun pour le survol
                square.setPrefSize(70, 70);

                // Ajouter le StackPane à la grille
                GridPane.setColumnIndex(square, col);
                GridPane.setRowIndex(square, row);
                chessboard.getChildren().add(square);

                // Facultatif : Garder les messages dans la console pour le survol

                squareOnMouseEntered(square,row,col);
                squareOnMouseExited(square,row,col);
                squareOnMouseClicked(square,row,col);


                System.out.println("Is occuped row: "+row+" col: "+col+" -> " + GameState.game.isPositionOccupied(row,col));
                if(GameState.game.isPositionOccupied(row,col)){
                    String image_path = GameState.game.getPieceIconPathAtPosition(row,col);
                    System.out.println("image_path: "+image_path);
                    if(image_path!=null){
                        URL imageURL = getClass().getResource(image_path);
                        assert imageURL != null;
                        ImageView piece_image = new ImageView(imageURL.toExternalForm());
                        piece_image.setFitWidth(70);
                        piece_image.setFitHeight(70);
                        square.getChildren().add(piece_image);
                    }else{}
                }
            }
        }


    }

    private void squareOnMouseExited(StackPane square, int row, int col) {
        square.onMouseExitedProperty().set(event -> {
            int a = row + col; // Exemple d'utilisation de la variable "a"
            //System.out.println("Mouse exited at [" + row + ", " + col + "], Calculated a = " + a);
        });
    }

    private void squareOnMouseEntered(StackPane square,int row,int col){

        square.onMouseEnteredProperty().set(event -> {
            //System.out.println("Mouse entered [" + row + ", " + col + "]")

        });

    }

    private void squareOnMousePressed(StackPane square,int row,int col){
        square.onMousePressedProperty().set(event -> {
            //System.out.println("Mouse pressed [" + row + ", " + col + "]")
        });
    }


    private void squareOnMouseClicked(StackPane square, int row, int col) {
        square.onMouseClickedProperty().set(event -> {
            Node current_clicked_square = (Node) event.getSource();
            boolean last_is_current = false;

            System.out.println("Mouse clicked [" + row + ", " + col + "]");

            // Logique pour vérifier si la position est occupée
            if (GameState.game.isPositionOccupied(row, col)) {
                System.out.println("Position is occupied at [" + row + ", " + col + "]");

                // Obtenez les mouvements possibles
                ArrayList<Position> possible_positions = GameState.game.getPieceAtPosition(row, col).getPositionPossibleMoves();

                System.out.println("POSSIBLE MOVES:");
                for (Position pos : possible_positions) {
                    System.out.println("row: " + pos.getPosY() + " col: " + pos.getPosX());

                    Node node = getNodeFromGridPane(this.chessboard, pos.getPosX(), pos.getPosY());
                    if (node == null) {
                        System.err.println("Warning: No node found at position [" + pos.getPosX() + ", " + pos.getPosY() + "]");
                        continue;
                    }

                    if (last_clicked_square == current_clicked_square) {
                        node.pseudoClassStateChanged(PseudoClass.getPseudoClass("possible_move"), false);
                        last_is_current = true;
                    } else {
                        node.pseudoClassStateChanged(PseudoClass.getPseudoClass("possible_move"), true);
                    }
                }



                // Réinitialiser les mouvements précédents si nécessaire
                if (last_clicked_square != null && !last_is_current) {
                    resetLastClickedSquareMoves(possible_positions);
                }

                // Mettre à jour la dernière case cliquée
                if (!last_is_current) {
                    last_clicked_square = current_clicked_square;
                    // Mettre à jour les mouvements possibles
                    last_clicked_square_possible_moves = possible_positions;
                } else {
                    last_clicked_square = null;
                    last_clicked_square_possible_moves = null;
                }
            }


        });
    }

    private void printGameState(){
        System.out.println("Is white turn: "+GameState.game.isWhiteTurn());
        System.out.println("Is black turn: "+GameState.game.isBlackTurn());
        System.out.println("Is game over: "+GameState.game.isGameOver());

    }

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            Integer nodeColumn = GridPane.getColumnIndex(node); // Colonne de l'enfant
            Integer nodeRow = GridPane.getRowIndex(node);       // Ligne de l'enfant

            // Sécurité contre les valeurs "null" pour les colonnes ou lignes
            if (nodeColumn != null && nodeRow != null && nodeColumn == col && nodeRow == row) {
                return node; // Retourne le Node correspondant
            }
        }
        return null; // Aucun node trouvé à cette position
    }

    private void resetLastClickedSquareMoves(ArrayList<Position> newList) {
        if (last_clicked_square_possible_moves != null) {
            for (Position position : last_clicked_square_possible_moves) {
                Node node = getNodeFromGridPane(this.chessboard, position.getPosX(), position.getPosY());
                if(!getIntersection(newList,last_clicked_square_possible_moves).contains(position)){
                    if (node != null) {
                        node.pseudoClassStateChanged(PseudoClass.getPseudoClass("possible_move"), false);
                    }
                }

            }
            last_clicked_square_possible_moves.clear(); // Nettoie la liste pour éviter qu'elle contienne des valeurs obsolètes
        }
    }

    private ArrayList<Position> getIntersection(ArrayList<Position> origin, ArrayList<Position> tests) {
        // Convertir 'tests' en HashSet pour une recherche plus rapide
        HashSet<Position> testSet = new HashSet<>(tests);
        ArrayList<Position> intersection = new ArrayList<>();

        for (Position pos : origin) {
            System.out.println("origin: " + pos.getPosX() + "," + pos.getPosY());
            if (testSet.contains(pos)) {
                System.out.println("intersection: " + pos.getPosX() + "," + pos.getPosY());
                intersection.add(pos);
            }
        }
        return intersection;
    }








}
