import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class NewGame {

    private JFrame newGame;
    private final Font font;

    public NewGame(){

        newGame = new JFrame("Welcome to the Chess Game!");
        newGame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        newGame.setBounds(500,150,400,450);
        newGame.setResizable(false);
        font = new Font("AliFont",Font.ITALIC,20);

        setPanel();

        newGame.setVisible(true);
    }

    private void setPanel(){

        JPanel panelGame = new JPanel();
        panelGame.setBackground(new Color(108, 165, 253));
        panelGame.setOpaque(true);

        ImageIcon background = new ImageIcon("Images/background/2.png");
        JLabel label_background = new JLabel(background);
        panelGame.add(label_background);
        panelGame.add(new JLabel());
        newGame.add(panelGame);

        setButtons(panelGame);
    }

    private void setButtons(JPanel panelGame){
        JButton humanPlayer = new JButton("Human Player");
        JButton aiPlayer = new JButton("Ai Player");
        humanPlayer.setFont(font);
        aiPlayer.setFont(font);
        humanPlayer.setBackground(new Color(89, 104, 228));
        aiPlayer.setBackground(new Color(89, 104, 228));

        panelGame.add(humanPlayer);
        panelGame.add(aiPlayer);



        humanPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HumanPlayer();
                newGame.setVisible(false);

            }
        });

        aiPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[][] places = new int[8][8];
                Game.startBoard(places);
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setBounds(300,100,800,700);
                frame.setResizable(false);
                frame.setLayout(new BorderLayout());
                frame.setVisible(true);

                Board b = null;
                try {
                    b = new Board(places,0,true,false);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                frame.add(b);
                frame.revalidate();
                newGame.setVisible(false);
            }
        });

    }
}