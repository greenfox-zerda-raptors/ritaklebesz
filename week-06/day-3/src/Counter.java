import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rita on 2016-11-23.
 */
public class Counter extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Counter();
            }
        });
    }

    int clicks;
    JLabel label;


    public Counter() {

        JPanel panel = new JPanel();
        this.setTitle("BasicExampleApplication");
        this.setSize(400,100);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width/2)-(this.getWidth()/2);
        int yPos = (dim.height/2)-(this.getHeight()/2);
        this.setLocation(xPos, yPos);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
        this.add(panel);
        JButton button = new JButton("Reset");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicks=0;
                label.setText("Pressed: " + clicks);
            }
        });
        JButton button2 = new JButton("Press me!");

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicks++;
                label.setText("Pressed: " + clicks);
            }
        });
        label = new JLabel("Pressed: 0");
        panel.add(button);
        panel.add(button2);
        panel.add(label);

    }
}
