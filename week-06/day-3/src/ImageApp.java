import javax.swing.*;
import java.awt.*;


/**
 * Created by Rita on 2016-11-23.
 */
public class ImageApp extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageApp();
            }
        });
    }

    JPanel panel;
    Toolkit tk;
    Dimension dim;
    Image image;
    Graphics graphics;

    public ImageApp() throws HeadlessException {
        panel = new JPanel();
        this.setTitle("Image App");
        this.setPreferredSize(new Dimension(300,276));
        tk = Toolkit.getDefaultToolkit();
        dim = tk.getScreenSize();
        int xPos = (dim.width/2)-(this.getWidth()/2);
        int yPos = (dim.height/2)-(this.getHeight()/2);
        this.setLocation(xPos, yPos);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
        this.add(panel);
        image = tk.createImage("C:\\Users\\Rita\\Pictures\\seal4.jpg");
        this.setContentPane(new ImagePanel(image));
        this.pack();
    }
}

class ImagePanel extends JComponent {
    private Image image;
    public ImagePanel(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocus();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
