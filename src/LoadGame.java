import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LoadGame {

    private Board b;
    public LoadGame(){


        int[][] places = new int[8][8];
        Game.startBoard(places);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBounds(300,100,800,700);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        b = null;

        
        try {
            b = new Board(readfromfile().arr,readfromfile().turn,readfromfile().ai_Player_Is_Playing == 1,readfromfile().ai_Player_Is_White == 1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        frame.add(b);
        frame.revalidate();
    }


    public static config readfromfile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Config/config.txt"));
        config help = new config();
        for(int i = 0 ; i< 8 ; i++){
            for(int j = 0 ; j < 8 ; j++){
                help.arr[i][j] = scanner.nextInt();
            }
        }
        help.turn = scanner.nextInt();
        help.ai_Player_Is_Playing = scanner.nextInt();
        help.ai_Player_Is_White = scanner.nextInt();
        return help;
    }


}
