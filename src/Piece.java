import javax.swing.*;
import java.awt.image.BufferedImage;

// an object from this class is a component

public class Piece extends JLabel {
    int id;
    BufferedImage image; // for the pic of pieces

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
