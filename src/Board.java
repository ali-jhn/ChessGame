import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class Board extends JPanel {

    private Cell[][] arr;
    private int[][] places = new int[8][8];
    private int[] save = new int[3]; // i  j   id
    private boolean white = true, AiPlayer_is_Playing = false, AiPlayer_is_white;
    private AIPlayer aiObject;



    public Board(int[][] Place,int turn,boolean aiPlayer_is_Playing,boolean aiPlayer_is_white) throws IOException {
        AiPlayer_is_Playing = aiPlayer_is_Playing;
        AiPlayer_is_white = aiPlayer_is_white;
        if(turn == 0){
            white = true;
        } else if(turn == 1){
            white = false;
        } else{
            System.out.println("turn must be equal 0 or 1 --> something is wrong");
        }

        this.setLayout(new GridLayout(8, 8));
        arr = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Place[i][j] == 1) {
                    places[i][j] = 1;
                    arr[i][j] = new Cell(i, j, this);
                    arr[i][j].setPiece(new W_King());
                    this.add(arr[i][j]);


                } else if (Place[i][j] == 2) {
                    places[i][j] = 2;
                    arr[i][j] = new Cell(i, j, this);
                    arr[i][j].setPiece(new W_Queen());
                    this.add(arr[i][j]);


                } else if (Place[i][j] == 3) {
                    places[i][j] = 3;
                    arr[i][j] = new Cell(i, j, this);
                    arr[i][j].setPiece(new W_Rook());
                    this.add(arr[i][j]);
                } else if (Place[i][j] == 4) {
                    places[i][j] = 4;
                    arr[i][j] = new Cell(i, j, this);
                    arr[i][j].setPiece(new W_Bishop());
                    this.add(arr[i][j]);
                } else if (Place[i][j] == 5) {
                    places[i][j] = 5;
                    arr[i][j] = new Cell(i, j, this);
                    arr[i][j].setPiece(new W_Knight());
                    this.add(arr[i][j]);
                } else if (Place[i][j] == 6) {
                    places[i][j] = 6;
                    arr[i][j] = new Cell(i, j, this);
                    arr[i][j].setPiece(new W_Pawn());
                    this.add(arr[i][j]);
                } else if (Place[i][j] == -1) {
                    places[i][j] = -1;
                    arr[i][j] = new Cell(i, j, this);
                    arr[i][j].setPiece(new B_King());
                    this.add(arr[i][j]);
                } else if (Place[i][j] == -2) {
                    places[i][j] = -2;
                    arr[i][j] = new Cell(i, j, this);
                    arr[i][j].setPiece(new B_Queen());
                    this.add(arr[i][j]);
                } else if (Place[i][j] == -3) {
                    places[i][j] = -3;
                    arr[i][j] = new Cell(i, j, this);
                    arr[i][j].setPiece(new B_Rook());
                    this.add(arr[i][j]);
                } else if (Place[i][j] == -4) {
                    places[i][j] = -4;
                    arr[i][j] = new Cell(i, j, this);
                    arr[i][j].setPiece(new B_Bishop());
                    this.add(arr[i][j]);
                } else if (Place[i][j] == -5) {
                    places[i][j] = -5;
                    arr[i][j] = new Cell(i, j, this);
                    arr[i][j].setPiece(new B_Knight());
                    this.add(arr[i][j]);
                } else if (Place[i][j] == -6) {
                    places[i][j] = -6;
                    arr[i][j] = new Cell(i, j, this);
                    arr[i][j].setPiece(new B_Pawn());
                    this.add(arr[i][j]);
                } else {
                    places[i][j] = 0;
                    arr[i][j] = new Cell(i, j, this);
                    arr[i][j].setPiece(new Piece());
                    this.add(arr[i][j]);
                }
            }
        }

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                int finalI = i;
                int finalJ = j;
                arr[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(!AiPlayer_is_Playing){
                            if (!arr[finalI][finalJ].getBackground().equals(Color.GREEN)) {
                                for (int i = 0; i < 8; i++)
                                    for (int j = 0; j < 8; j++) {
                                        arr[i][j].defaultColor();
                                    }
                                if(white){
                                    if(arr[finalI][finalJ].getPiece().getId()>0){
                                        save[0] = finalI;
                                        save[1] = finalJ;
                                        save[2] = arr[finalI][finalJ].getPiece().getId();

                                        for (Cell cell : arr[finalI][finalJ].availaleCell()) {
                                            cell.setBackground(Color.green);
                                        }
                                        white = false;
                                    }
                                } else{
                                    if(arr[finalI][finalJ].getPiece().getId()<0){
                                        save[0] = finalI;
                                        save[1] = finalJ;
                                        save[2] = arr[finalI][finalJ].getPiece().getId();

                                        for (Cell cell : arr[finalI][finalJ].availaleCell()) {
                                            cell.setBackground(Color.green);
                                        }
                                        white = true;

                                    }
                                }

                            } else {
                                if(places[finalI][finalJ] == 1 || places[finalI][finalJ] == -1){
                                    JFrame endgame = new JFrame("THE GAME HAS BEEN ENDED!");
                                    endgame.setSize(500,200);
                                    endgame.setResizable(false);
                                    JPanel panel = new JPanel();
                                    panel.setBackground(Color.CYAN);
                                    JButton butt = new JButton("CLICK HERE TO EXIT THE GAME");
                                    panel.setOpaque(true);
                                    endgame.add(panel);
                                    endgame.setVisible(true);
                                    panel.add(butt);


                                    butt.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            int[][] temp = new int[8][8];
                                            Game.startBoard(temp);
                                            PrintStream printStream = null;
                                            try {
                                                printStream = new PrintStream("Config/config.txt");
                                            } catch (FileNotFoundException ex) {
                                                ex.printStackTrace();
                                            }
                                            for(int i = 0 ; i< 8 ; i++){
                                                for(int j = 0 ; j < 8 ; j++){
                                                    printStream.print(temp[i][j] + " ");
                                                }
                                                printStream.println();
                                            }
                                            printStream.println(0);

                                            System.exit(0);
                                        }
                                    });

                                }
                                places[finalI][finalJ] = save[2];
                                places[save[0]][save[1]] = 0;
                                arr[finalI][finalJ].removePiece();
                                arr[finalI][finalJ].setPiece(arr[save[0]][save[1]].getPiece());
                                arr[finalI][finalJ].repaint();
                                arr[save[0]][save[1]].repaint();
                                try {
                                    PrintStream printStream = new PrintStream("Config/config.txt");
                                    for(int i = 0 ; i< 8 ; i++){
                                        for(int j = 0 ; j< 8 ; j++){
                                            printStream.print(places[i][j] + " ");
                                        }
                                        printStream.println();
                                    }
                                    if(white)
                                        printStream.print(0 + " ");
                                    else
                                        printStream.print(1 + " ");
                                    printStream.print(0 + " "); // becuase ai is not playing
                                    printStream.print(0 + " ");// ( or 1 ) actually it doesnt matter becuase
                                    // we dont have ai player in this case
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                }
                                for (int i = 0; i < 8; i++)
                                    for (int j = 0; j < 8; j++) {
                                        arr[i][j].defaultColor();
                                    }
                            }
                        }
                        else { // Ai Player is playing
                            if (aiPlayer_is_white)
                                white = false;
                            else
                                white = true;

                            if (!arr[finalI][finalJ].getBackground().equals(Color.GREEN)) {
                                for (int i = 0; i < 8; i++)
                                    for (int j = 0; j < 8; j++) {
                                        arr[i][j].defaultColor();
                                    }
                                if(white){
                                    if(arr[finalI][finalJ].getPiece().getId()>0){
                                        save[0] = finalI;
                                        save[1] = finalJ;
                                        save[2] = arr[finalI][finalJ].getPiece().getId();

                                        for (Cell cell : arr[finalI][finalJ].availaleCell()) {
                                            cell.setBackground(Color.green);
                                        }

                                    }
                                } else{
                                    if(arr[finalI][finalJ].getPiece().getId()<0){
                                        save[0] = finalI;
                                        save[1] = finalJ;
                                        save[2] = arr[finalI][finalJ].getPiece().getId();

                                        for (Cell cell : arr[finalI][finalJ].availaleCell()) {
                                            cell.setBackground(Color.green);
                                        }
                                    }
                                }
                            } else {
                                if(places[finalI][finalJ] == 1 || places[finalI][finalJ] == -1){
                                    JFrame endgame = new JFrame("THE GAME HAS BEEN ENDED!");
                                    endgame.setSize(500,200);
                                    endgame.setResizable(false);
                                    JPanel panel = new JPanel();
                                    panel.setBackground(Color.CYAN);
                                    JButton butt = new JButton("CLICK HERE TO EXIT THE GAME");
                                    panel.setOpaque(true);
                                    endgame.add(panel);
                                    endgame.setVisible(true);
                                    panel.add(butt);


                                    butt.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            int[][] temp = new int[8][8];
                                            Game.startBoard(temp);
                                            PrintStream printStream = null;
                                            try {
                                                printStream = new PrintStream("Config/config.txt");
                                            } catch (FileNotFoundException ex) {
                                                ex.printStackTrace();
                                            }
                                            for(int i = 0 ; i< 8 ; i++){
                                                for(int j = 0 ; j < 8 ; j++){
                                                    printStream.print(temp[i][j] + " ");
                                                }
                                                printStream.println();
                                            }
                                            printStream.println(0);
                                            System.exit(0);
                                        }
                                    });

                                } // when we delete king and game ends
                                places[finalI][finalJ] = save[2];
                                places[save[0]][save[1]] = 0;
                                arr[finalI][finalJ].removePiece();
                                arr[finalI][finalJ].setPiece(arr[save[0]][save[1]].getPiece());
                                arr[finalI][finalJ].repaint();
                                arr[save[0]][save[1]].repaint();


                                aiObject = new AIPlayer();
                                int[][] temp = new int[8][8];
                                changearray1to2(temp,places);
                                int[][] after = new int[8][8];
                                changearray1to2(after,aiObject.nextMove(places,AiPlayer_is_white));
                                // now temp = places  ;  "after" array = after ai player has moved
                                helpAi helpai = new helpAi();
                                helpai = differences(temp,after);
                                places[helpai.x2][helpai.y2] = helpai.id;
                                places[helpai.x1][helpai.y1] = 0;
                                arr[helpai.x2][helpai.y2].removePiece();
                                arr[helpai.x2][helpai.y2].setPiece(arr[helpai.x1][helpai.y1].getPiece());
                                arr[helpai.x2][helpai.y2].repaint();
                                arr[helpai.x1][helpai.y1].repaint();
                                if(helpai.vari == 1 || helpai.vari == -1){
                                    JFrame endgame = new JFrame("THE GAME HAS BEEN ENDED!");
                                    endgame.setSize(500,200);
                                    endgame.setResizable(false);
                                    JPanel panel = new JPanel();
                                    panel.setBackground(Color.CYAN);
                                    JButton butt = new JButton("CLICK HERE TO EXIT THE GAME");
                                    panel.setOpaque(true);
                                    endgame.add(panel);
                                    endgame.setVisible(true);
                                    panel.add(butt);


                                    butt.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            int[][] temp = new int[8][8];
                                            Game.startBoard(temp);
                                            PrintStream printStream = null;
                                            try {
                                                printStream = new PrintStream("Config/config.txt");
                                            } catch (FileNotFoundException ex) {
                                                ex.printStackTrace();
                                            }
                                            for(int i = 0 ; i< 8 ; i++){
                                                for(int j = 0 ; j < 8 ; j++){
                                                    printStream.print(temp[i][j] + " ");
                                                }
                                                printStream.println();
                                            }
                                            printStream.println(0);
                                            System.exit(0);
                                        }
                                    });

                                }
                                try {
                                    PrintStream printStream = new PrintStream("Config/config.txt");
                                    for(int i = 0 ; i< 8 ; i++){
                                        for(int j = 0 ; j< 8 ; j++){
                                            printStream.print(places[i][j] + " ");
                                        }
                                        printStream.println();
                                    }
                                    if(white)
                                        printStream.print(0 + " ");
                                    else
                                        printStream.print(1 + " ");
                                    printStream.print(1 + " "); // becuase we are playing with ai player
                                    printStream.print(AiPlayer_is_white ? 1 : 0);
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                }
                                for (int i = 0; i < 8; i++)
                                    for (int j = 0; j < 8; j++) {
                                        arr[i][j].defaultColor();
                                    }
                            }


                        }


                    }
                });


            }
    }

    public Cell[][] getArr() {
        return arr;
    }

    //in constructor

    // too actionlistener array avaz she

    public int[][] getPlaces() {
        return places;
    }

    // private becuase i need it only in this class when
    // there is a AiPlayer
    private static void changearray1to2(int[][] arr1,int[][] arr2){
        for(int i = 0 ; i< 8 ; i++){
            for(int j = 0 ; j< 8 ; j++)
                arr1[i][j] = arr2[i][j];
        }
    }

    private static helpAi differences(int[][] arr1 , int[][] arr2){

        helpAi o = new helpAi();
        int c = 0;
        for(int i = 0 ; i< 8 ; i++){
            for(int j = 0 ; j< 8 ; j++){
                if(arr1[i][j] != arr2[i][j]){
                    if(arr2[i][j] == 0){
                        o.x1 = i;
                        o.y1 = j;
                    } else{
                        o.x2 = i;
                        o.y2 = j;
                        o.id = arr2[i][j];
                        o.vari = arr1[i][j];

                    }

                }

            }
        }
        return o;
    }


}

class helpAi{
    int x1;
    int y1;
    int x2;
    int y2;
    int id;
    int vari;
}
