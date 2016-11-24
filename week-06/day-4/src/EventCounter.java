import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Rita on 2016-11-24.
 */
public class EventCounter extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EventCounter();
            }
        });
    }

    int mouseEvents = 0;
    int windowEvents = 0;
    int keyEvents = 0;
    JLabel mouseEventCounter = new JLabel("Number of clicks: ");
    JLabel windowEventCounter = new JLabel("Number of window events: ");
    JLabel keyEventCounter = new JLabel("Number of key events: ");
    JTextField textField = new JTextField();

    public EventCounter() {

        JPanel panel = new JPanel();
        this.setTitle("Event Counter");
        this.setSize(400,100);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width/2)-(this.getWidth()/2);
        int yPos = (dim.height/2)-(this.getHeight()/2);
        this.setLocation(xPos, yPos);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
        this.add(panel);
        panel.add(mouseEventCounter);
        panel.add(windowEventCounter);
        panel.add(keyEventCounter);
        panel.add(textField);
        textField.addKeyListener(listenForKeys);
        this.addMouseListener(listenForMouse);
        this.addWindowListener(listenForWindow);
    }

    KeyListener listenForKeys = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            keyEvents++;
            keyEventCounter.setText("Number of key events: " + keyEvents);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            keyEvents++;
            keyEventCounter.setText("Number of key events: " + keyEvents);
        }
    };

    MouseListener listenForMouse = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            mouseEvents++;
            mouseEventCounter.setText("Number of clicks: " + mouseEvents);
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    };

    WindowListener listenForWindow = new WindowListener() {
        @Override
        public void windowOpened(WindowEvent e) {
            windowEvents++;
            windowEventCounter.setText("Number of window events: " + windowEvents);
        }

        @Override
        public void windowClosing(WindowEvent e) {}

        @Override
        public void windowClosed(WindowEvent e) {}

        @Override
        public void windowIconified(WindowEvent e) {
            windowEvents++;
            windowEventCounter.setText("Number of window events: " + windowEvents);
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            windowEvents++;
            windowEventCounter.setText("Number of window events: " + windowEvents);
        }

        @Override
        public void windowActivated(WindowEvent e) {
            windowEvents++;
            windowEventCounter.setText("Number of window events: " + windowEvents);
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            windowEvents++;
            windowEventCounter.setText("Number of window events: " + windowEvents);
        }
    };
}
