import javax.swing.*;
import java.awt.*;

/**
 * Created by Rita on 2016-11-24.
 */
public class ImagePanel extends JPanel {

    Image image;

    public ImagePanel() {
        image = Toolkit.getDefaultToolkit().createImage("image.jpg");
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        requestFocus();
        graphics.drawImage(image, 7, 25, this);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Ariel", Font.BOLD, 20));
        graphics.drawString("Heroes of Might and Magic V", 110, 420);

        graphics.setColor(new Color(200, 200, 100));
        graphics.drawOval(270, 45, 70, 120);

        graphics.setColor(Color.BLUE);
        graphics.fillRect(280, 100, 50, 10);

        graphics.setColor(Color.PINK);
        graphics.fillOval(230, 210, 15, 15);
        graphics.fillOval(290, 210, 15, 15);
    }
}
