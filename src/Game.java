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

        setPanel();

        startFrame.setVisible(true);
    }

    private void setPanel(){
        JPanel startPanel = new JPanel();
        startPanel.setOpaque(true);
        startPanel.setBackground(new Color(4, 13, 31));

        ImageIcon chess = new ImageIcon("Images/background/1.png");
        JLabel label = new JLabel(chess);
        startPanel.add(label);
        startPanel.add(new JLabel());
        startFrame.add(startPanel);

    }

}
