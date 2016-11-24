import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rita on 2016-11-24.
 */
public class WrapperApp extends JFrame implements ActionListener {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WrapperApp();
            }
        });
    }

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;

    public WrapperApp() throws HeadlessException {

        this.setTitle("Event Counter");
        this.setSize(500,500);
        this.setResizable(false);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width/2)-(this.getWidth()/2);
        int yPos = (dim.height/2)-(this.getHeight()/2);
        this.setLocation(xPos, yPos);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        menuBar.add(menu);
        menuItem = new JMenuItem("Exit");
        menu.add(menuItem);
        this.setJMenuBar(menuBar);
        menuItem.addActionListener(this);
        JPanel imagePanel = new ImagePanel();
        this.add(imagePanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
