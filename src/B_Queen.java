import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class B_Queen extends Piece{
    public B_Queen() throws IOException {
        id = -2;
        this.setPreferredSize(new Dimension(100, 100));
        this.setBackground(Color.WHITE);
        this.image = ImageIO.read(this.getClass().getResource("Images/pieces/black/queen.png"));

    }
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawImage(this.image, 0, 0, this);
    }
}
