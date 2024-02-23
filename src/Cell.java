import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cell extends JButton implements MouseListener {
    Board board;
    Piece piece = null;
    int i, j;



    public void setPiece(Piece piece) {
        this.piece = piece;
        this.add(piece);
    }

    public Piece getPiece() {
        return piece;
    }

    public Cell(int x, int y , Board b) throws IOException {
        board = b;
        this.i = x;
        this.j = y;

        defaultColor();
        this.setLayout(new BorderLayout());

    }

    public Cell(){}

    @Override
    public void mouseClicked(MouseEvent e) {
    }


        //find available cells a piece can go
        public List<Cell> availaleCell(){

            List<Cell> moves = new ArrayList<>();
            int id = this.piece.getId();

            if (id == 0){//doesnt have a movement
            }else if(id == 1 || id == -1){
                if (this.i+1 < 8 && this.j + 1 < 8 && board.getPlaces()[i+1][j+1]*this.getPiece().getId() < 0){
                    moves.add(board.getArr()[i+1][j+1]);
                }
                if (this.i+0 < 8 && this.j + 1 < 8 && board.getPlaces()[i+0][j+1]*this.getPiece().getId() < 0){
                    moves.add(board.getArr()[i+0][j+1]);
                }
                if (this.i-1 > 0 && this.j + 1 < 8 && board.getPlaces()[i-1][j+1]*this.getPiece().getId() < 0){
                    moves.add(board.getArr()[i-1][j+1]);
                }
                if (this.i-1 > 0 && this.j + 0 < 8 && board.getPlaces()[i-1][j+0]*this.getPiece().getId() < 0){
                    moves.add(board.getArr()[i-1][j+0]);
                }
                if (this.i-1 > 0 && this.j - 1 > 0 && board.getPlaces()[i-1][j-1]*this.getPiece().getId() < 0){
                    moves.add(board.getArr()[i-1][j-1]);
                }
                if (this.i+0 < 8 && this.j - 1 > 0 && board.getPlaces()[i+0][j-1]*this.getPiece().getId() < 0){
                    moves.add(board.getArr()[i+0][j-1]);
                }
                if (this.i+1 < 8 && this.j - 1 > 0 && board.getPlaces()[i+1][j-1]*this.getPiece().getId() < 0){
                    moves.add(board.getArr()[i+1][j-1]);
                }
                if (this.i+1 < 8 && this.j + 0 < 8 && board.getPlaces()[i+1][j+0]*this.getPiece().getId() < 0){
                    moves.add(board.getArr()[i+1][j+0]);
                }
            }else if(id == 2 || id == -2){
                for (int c = 1; c < 7 - this.j ;c++){
                    if (board.getPlaces()[this.i][this.j + c]*board.getPlaces()[this.i][this.j] <= 0){
                        moves.add(board.getArr()[this.i][this.j + c]);
                        if (board.getPlaces()[this.i][this.j + c]*board.getPlaces()[this.i][this.j] < 0){
                            break;
                        }
                    }else {
                        break;
                    }
                }
                for (int c = 1; c <= this.j; c++){
                    if (board.getPlaces()[this.i][this.j - c]*board.getPlaces()[this.i][this.j] <= 0){
                        moves.add(board.getArr()[this.i][this.j - c]);
                        if (board.getPlaces()[this.i][this.j - c]*board.getPlaces()[this.i][this.j] < 0){
                            break;
                        }
                    }else {
                        break;
                    }
                }
                for (int count = 1; count <= this.i; count++){
                    if (board.getPlaces()[this.i-count][this.j]*board.getPlaces()[this.i][this.j] <= 0){
                        moves.add(board.getArr()[this.i-count][this.j]);
                        if (board.getPlaces()[this.i-count][this.j]*board.getPlaces()[this.i][this.j] < 0){
                            break;
                        }
                    }else {
                        break;
                    }
                }
                for (int count = 1; count <= 7 - this.i; count++){
                    if (board.getPlaces()[this.i+count][this.j]*board.getPlaces()[this.i][this.j] <= 0){
                        moves.add(board.getArr()[this.i+count][this.j]);
                        if (board.getPlaces()[this.i+count][this.j]*board.getPlaces()[this.i][this.j] < 0){
                            break;
                        }
                    }else {
                        break;
                    }
                }
                for (int count = 1; this.i-count >= 0 && this.j + count < 8; count++){
                    if (board.getPlaces()[this.i-count][this.j+count]*board.getPlaces()[this.i][this.j] <= 0){
                        moves.add(board.getArr()[this.i-count][this.j+count]);
                        if (board.getPlaces()[this.i-count][this.j+count]*board.getPlaces()[this.i][this.j] < 0){
                            break;
                        }
                    }else {
                        break;
                    }
                }
                for (int count = 1; this.i+count < 8 && this.j + count < 8; count++){
                    if (board.getPlaces()[this.i+count][this.j+count]*board.getPlaces()[this.i][this.j] <= 0){
                        moves.add(board.getArr()[this.i+count][this.j+count]);
                        if (board.getPlaces()[this.i+count][this.j+count]*board.getPlaces()[this.i][this.j] < 0){
                            break;
                        }
                    }else {
                        break;
                    }
                }
                for (int count = 1; this.i+count < 8 && this.j - count >= 0; count++){
                    if (board.getPlaces()[this.i+count][this.j-count]*board.getPlaces()[this.i][this.j] <= 0){
                        moves.add(board.getArr()[this.i+count][this.j-count]);
                        if (board.getPlaces()[this.i+count][this.j-count]*board.getPlaces()[this.i][this.j] < 0){
                            break;
                        }
                    }else {
                        break;
                    }
                }
                for (int count = 1; this.i-count >= 0 && this.j - count >= 0; count++){
                    if (board.getPlaces()[this.i-count][this.j-count]*board.getPlaces()[this.i][this.j] <= 0){
                        moves.add(board.getArr()[this.i-count][this.j-count]);
                        if (board.getPlaces()[this.i-count][this.j-count]*board.getPlaces()[this.i][this.j] < 0){
                            break;
                        }
                    }else {
                        break;
                    }
                }
            }else if(id == 3 || id == -3){
                for (int c = 1; c < 7 - this.j ;c++){
                    if (board.getPlaces()[this.i][this.j + c]*board.getPlaces()[this.i][this.j] <= 0){
                        moves.add(board.getArr()[this.i][this.j + c]);
                        if (board.getPlaces()[this.i][this.j + c]*board.getPlaces()[this.i][this.j] < 0){
                            break;
                        }
                    }else {
                        break;
                    }
                }
                for (int c = 1; c <= this.j; c++){
                    if (board.getPlaces()[this.i][this.j - c]*board.getPlaces()[this.i][this.j] <= 0){
                        moves.add(board.getArr()[this.i][this.j - c]);
                        if (board.getPlaces()[this.i][this.j - c]*board.getPlaces()[this.i][this.j] < 0){
                            break;
                        }
                    }else {
                        break;
                    }
                }
                for (int count = 1; count <= this.i; count++){
                    if (board.getPlaces()[this.i-count][this.j]*board.getPlaces()[this.i][this.j] <= 0){
                        moves.add(board.getArr()[this.i-count][this.j]);
                        if (board.getPlaces()[this.i-count][this.j]*board.getPlaces()[this.i][this.j] < 0){
                            break;
                        }
                    }else {
                        break;
                    }
                }
                for (int count = 1; count <= 7 - this.i; count++){
                    if (board.getPlaces()[this.i+count][this.j]*board.getPlaces()[this.i][this.j] <= 0){
                        moves.add(board.getArr()[this.i+count][this.j]);
                        if (board.getPlaces()[this.i+count][this.j]*board.getPlaces()[this.i][this.j] < 0){
                            break;
                        }
                    }else {
                        break;
                    }
                }
            }else if(id==4 || id==-4){
                for (int count = 1; this.i-count >= 0 && this.j + count < 8; count++){
                    if (board.getPlaces()[this.i-count][this.j+count]*board.getPlaces()[this.i][this.j] <= 0){
                        moves.add(board.getArr()[this.i-count][this.j+count]);
                        if (board.getPlaces()[this.i-count][this.j+count]*board.getPlaces()[this.i][this.j] < 0){
                            break;
                        }
                    }else {
                        break;
                    }
                }
                for (int count = 1; this.i+count < 8 && this.j + count < 8; count++){
                    if (board.getPlaces()[this.i+count][this.j+count]*board.getPlaces()[this.i][this.j] <= 0){
                        moves.add(board.getArr()[this.i+count][this.j+count]);
                        if (board.getPlaces()[this.i+count][this.j+count]*board.getPlaces()[this.i][this.j] < 0){
                            break;
                        }
                    }else {
                        break;
                    }
                }
                for (int count = 1; this.i+count < 8 && this.j - count >= 0; count++){
                    if (board.getPlaces()[this.i+count][this.j-count]*board.getPlaces()[this.i][this.j] <= 0){
                        moves.add(board.getArr()[this.i+count][this.j-count]);
                        if (board.getPlaces()[this.i+count][this.j-count]*board.getPlaces()[this.i][this.j] < 0){
                            break;
                        }
                    }else {
                        break;
                    }
                }
                for (int count = 1; this.i-count >= 0 && this.j - count >= 0; count++){
                    if (board.getPlaces()[this.i-count][this.j-count]*board.getPlaces()[this.i][this.j] <= 0){
                        moves.add(board.getArr()[this.i-count][this.j-count]);
                        if (board.getPlaces()[this.i-count][this.j-count]*board.getPlaces()[this.i][this.j] < 0){
                            break;
                        }
                    }else {
                        break;
                    }
                }
            }else if(id==5 || id==-5){
                if (this.i-1 >= 0 && this.j + 2 < 8 ){
                    if (board.getPlaces()[i-1][j+2]*board.getPlaces()[this.i][this.j] <= 0){
                        moves.add(board.getArr()[this.i-1][this.j + 2]);
                    }
                }
                if (this.i-1 >= 0 && this.j - 2 >= 0){
                    if (board.getPlaces()[i-1][j-2]*board.getPlaces()[this.i][this.j] <= 0) {
                        moves.add(board.getArr()[this.i-1][this.j - 2]);
                    }
                }
                if (this.i+1 < 8 && this.j + 2 < 8){
                    if (board.getPlaces()[i+1][j+2]*board.getPlaces()[this.i][this.j] <= 0) {
                        moves.add(board.getArr()[this.i+1][this.j + 2]);
                    }
                }
                if (this.i+1 < 8 && this.j - 2 >= 0){
                    if (board.getPlaces()[i+1][j-2]*board.getPlaces()[this.i][this.j] <= 0) {
                        moves.add(board.getArr()[this.i+1][this.j - 2]);
                    }
                }
                if (this.i+2 < 8 && this.j - 1 >= 0){
                    if (board.getPlaces()[i+2][j-1]*board.getPlaces()[this.i][this.j] <= 0) {
                        moves.add(board.getArr()[this.i+2][this.j - 1]);
                    }
                }
                if (this.i-2 >= 0 && this.j - 1 >= 0){
                    if (board.getPlaces()[i-2][j-1]*board.getPlaces()[this.i][this.j] <= 0) {
                        moves.add(board.getArr()[this.i-2][this.j - 1]);
                    }
                }
                if (this.i+2 < 8 && this.j + 1 < 8){
                    if (board.getPlaces()[i+2][j+1]*board.getPlaces()[this.i][this.j] <= 0) {
                        moves.add(board.getArr()[this.i+2][this.j + 1]);
                    }
                }
                if (this.i-2 >= 0 && this.j + 1 < 8){
                    if (board.getPlaces()[i-2][j+1]*board.getPlaces()[this.i][this.j] <= 0) {
                        moves.add(board.getArr()[this.i-2][this.j + 1]);
                    }
                }
            }else if(id ==6){ // white pawn goes up but black pawn goes down
                if (this.i-1 >= 0){
                    if(board.getPlaces()[this.i-1][this.j] == 0) {
                        moves.add(board.getArr()[this.i-1][this.j]);
                    }
                }
                if (this.i == 6 && board.getPlaces()[this.i-1][this.j] == 0) {
                    if (board.getPlaces()[this.i-2][this.j] == 0) {
                        moves.add(board.getArr()[this.i-2][this.j]);
                    }
                }
                if(this.i-1 >= 0 && this.j + 1 < 8) {
                    if (board.getPlaces()[this.i-1][this.j + 1]*board.getPlaces()[this.i][this.j] < 0) {
                        moves.add(board.getArr()[this.i-1][this.j + 1]);
                    }
                }
                if(this.i-1 >= 0 && this.j - 1 >= 0) {
                    if (board.getPlaces()[this.i-1][this.j - 1]*board.getPlaces()[this.i][this.j] < 0) {
                        moves.add(board.getArr()[this.i-1][this.j - 1]);
                    }
                }
            }else if(id ==-6){ // white pawn goes up but black pawn goes down
                if(this.i+1 <8) {
                    if (board.getPlaces()[this.i+1][this.j]*board.getPlaces()[this.i][this.j] == 0) {
                        moves.add(board.getArr()[this.i+1][this.j]);
                    }
                }
                if (this.i == 1 && board.getPlaces()[this.i+1][this.j] == 0) {
                    if (board.getPlaces()[this.i+2][this.j]*board.getPlaces()[this.i][this.j] == 0) {
                        moves.add(board.getArr()[this.i+2][this.j]);
                    }
                }
                if(this.i+1 < 8 && this.j + 1 < 8) {
                    if (board.getPlaces()[this.i+1][this.j + 1]*board.getPlaces()[this.i][this.j] < 0) {
                        moves.add(board.getArr()[this.i+1][this.j + 1]);
                    }
                }
                if(this.i+1 < 8 && this.j - 1 >= 0) {
                    if (board.getPlaces()[this.i+1][this.j - 1]*board.getPlaces()[this.i][this.j] < 0) {
                        moves.add(board.getArr()[this.i+1][this.j - 1]);
                    }
                }
            }else{ // not a case

            }

            return moves;
        }



    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
    //change color to default color
    public void defaultColor(){
        if ((i + j) % 2 == 1) {
            setBackground(new Color(192,192,192));
        } else {
            setBackground(new Color(9, 68, 182));
        }
    }
    //remove piece from board
    public void removePiece() {
        if (piece != null) {
            piece.image = null;
            piece.setVisible(false);
            piece = null;

        }
    }
}
