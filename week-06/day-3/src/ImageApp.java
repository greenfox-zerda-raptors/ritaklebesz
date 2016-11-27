import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;


/**
 * Created by Rita on 2016-11-23.
 */
public class ImageApp extends JFrame implements ComponentListener {
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
        image = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Rita\\Pictures\\seal4.jpg");
        this.setContentPane(new ImagePanel(image));
        pack();
    }

    @Override
    public void componentResized(ComponentEvent arg0) {
        Rectangle b = arg0.getComponent().getBounds();
        arg0.getComponent().setBounds(b.x, b.y, b.width, b.width);

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

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


