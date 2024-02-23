import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;


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


        this.setLayout(new BorderLayout());

    }

    public Cell(){}

    @Override
    public void mouseClicked(MouseEvent e) {
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

}
