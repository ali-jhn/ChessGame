import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class B_Pawn extends Piece{
    public B_Pawn() throws IOException {
        id = -6;
        this.setPreferredSize(new Dimension(100, 100));
        this.setBackground(Color.WHITE);
        this.image = ImageIO.read(this.getClass().getResource("Images/pieces/black/pawn.png"));
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(this.image, 0, 0, this);
    }

}
