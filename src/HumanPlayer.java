import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class HumanPlayer {
    private JFrame frame;
    private int[][] places;
    public HumanPlayer(){
        places = new int[8][8];
        Game.startBoard(places);
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBounds(300,100,800,700);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        setBoard();

        frame.revalidate();
    }

    private void setBoard(){
        Board b = null;
        try {
            b = new Board(places,0,false,true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        frame.add(b);
    }
}
