import javax.swing.*;
import java.awt.*;


public class Game {
    private JFrame startFrame;
    private final Font font;

    public Game(){

        startFrame = new JFrame("CHESS GAME!");
        startFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        startFrame.setResizable(false);
        startFrame.setBounds(500,150,400,450);

        font = new Font("AliFont",Font.ITALIC,20);


        startFrame.setVisible(true);
    }



}
