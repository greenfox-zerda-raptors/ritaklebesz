import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rita on 2016-11-24.
 */
public class WorkshopWrapper extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItemExit;
    JMenuItem menuItemEventCounter;
    JMenuItem menuItemWrapperApp;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WorkshopWrapper();
            }
        });
    }

    public WorkshopWrapper() throws HeadlessException {


        this.setTitle("Workshop Wrapper");
        this.setSize(500, 500);
        this.setResizable(false);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);
        this.setLocation(xPos, yPos);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        menuBar.add(menu);
        menuItemExit = new JMenuItem("Exit");
        menu.add(menuItemExit);
        this.setJMenuBar(menuBar);
        menuItemExit.addActionListener(this);
        menuItemEventCounter = new JMenuItem("Event Counter");
        menu.add(menuItemEventCounter);
        menuItemEventCounter.addActionListener(this);
        menuItemWrapperApp = new JMenuItem("Wrapper App/Draw an image");
        menu.add(menuItemWrapperApp);
        menuItemWrapperApp.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == menuItemExit) {
            System.exit(0);
        } else if (event.getSource() == menuItemEventCounter) {
            getContentPane().add(new EventCounterPanel());
        } else if (event.getSource() == menuItemWrapperApp) {
            getContentPane().add(new WrapperAppPanel());
        }
    }
}
