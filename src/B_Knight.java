import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class B_Knight extends Piece{
    public B_Knight() throws IOException {
        id = -5;
        this.setPreferredSize(new Dimension(100, 100));
        this.setBackground(Color.WHITE);
        this.image = ImageIO.read(this.getClass().getResource("Images/pieces/black/knight.png"));


    }
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawImage(this.image,0,0,this);
    }

}
