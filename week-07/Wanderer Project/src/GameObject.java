import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Rita on 2016-12-06.
 */
public class GameObject {
    BufferedImage image;
    int posX, posY;

    public GameObject() {
        this("hero.png", 0, 0);
    }

    public GameObject(String filename, int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics graphics) {
        if (image != null) {
            graphics.drawImage(image, posX *72, posY*72, null);
        }
    }

    public int[] getCoordinates() {
        return new int[]{posX, posY};
    }

    public void updateImage(String filename) {
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
