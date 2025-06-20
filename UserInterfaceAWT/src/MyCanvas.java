import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyCanvas extends Canvas {
    private static final long serialVersionUID = 1L;
    private BufferedImage myImage;

    public MyCanvas() {
        try {
            myImage = ImageIO.read(new File("java.jpg"));
        } catch (IOException e) {
            System.out.println("Can't load image");
        }
    }

    public void paint(Graphics g) {
        g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
        g.setColor(Color.red);
        g.fillOval(50, 50, 70, 70);
        g.setColor(Color.yellow);
        g.fillRect(this.getWidth() - 100, 10, 90, getHeight() - 20);
    }
}
