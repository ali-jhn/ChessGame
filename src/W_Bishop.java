import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;


public class W_Bishop extends Piece{

    public W_Bishop() throws IOException {
        id = 4;
        this.setPreferredSize(new Dimension(100, 100));
        this.setBackground(Color.WHITE);
        this.image = ImageIO.read(this.getClass().getResource("Images/pieces/white/bishop.png"));

    }
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawImage(this.image, 0, 0, this);
    }


}
