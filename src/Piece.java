import javax.swing.*;
import java.awt.image.BufferedImage;

public class Piece extends JLabel {
    int id;
    BufferedImage image;

    public int getId() {
        return id;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Piece(int id, BufferedImage image){
        this.id = id;
        this.image = image;
    }
    public Piece(){}



}
