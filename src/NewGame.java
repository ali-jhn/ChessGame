import javax.swing.*;
import java.awt.*;


public class NewGame {

    private JFrame newGame;
    private final Font font;

    public NewGame(){

        newGame = new JFrame("Welcome to the Chess Game!");
        newGame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        newGame.setBounds(500,150,400,450);
        newGame.setResizable(false);
        font = new Font("AliFont",Font.ITALIC,20);
        newGame.setVisible(true);
    }



}