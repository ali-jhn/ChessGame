import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        setButtons(startPanel);
    }

    private void setButtons(JPanel startPanel){
        JButton newGame = new JButton("New Game");
        JButton loadGame = new JButton("Load Game");
        newGame.setFont(font);
        loadGame.setFont(font);
        newGame.setBackground(new Color(85, 136, 188));
        loadGame.setBackground(new Color(85,136,188));
        startPanel.add(newGame);
        startPanel.add(loadGame);

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewGame();
                startFrame.setVisible(false);
            }
        });

        loadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoadGame();
                startFrame.setVisible(false);
            }
        });
    }

    public static void startBoard(int[][] arr){ // public becuase i used it in Board class
        for(int i =0 ; i< 8 ; i+=7 ){
            for(int j = 0 ; j< 8 ; j++){
                if(i==0){
                    if(j == 0 || j == 7)
                        arr[i][j] = -3;
                    else if(j == 1 || j== 6)
                        arr[i][j] = -5;
                    else if (j == 2 || j == 5)
                        arr[i][j] = -4;
                    else if(j == 3)
                        arr[i][j] = -1;
                    else
                        arr[i][j] = -2 ;
                } else {
                    if(j == 0 || j == 7)
                        arr[i][j] = 3;
                    else if(j == 1 || j== 6)
                        arr[i][j] = 5;
                    else if (j == 2 || j == 5)
                        arr[i][j] = 4;
                    else if(j == 3)
                        arr[i][j] = 1;
                    else
                        arr[i][j] = 2 ;

                }
            }
        }
        for(int i = 1 ; i < 8 ; i+=5){
            if(i == 1){
                for(int j = 0 ; j < 8 ; j++)
                    arr[i][j] = -6;
            } else{
                for(int j = 0 ; j < 8 ; j++)
                    arr[i][j] = 6;
            }
        }
    }

}
