import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rita on 2016-11-23.
 */
public class UIControls extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UIControls();
            }
        });
    }

    JLabel label1;
    JLabel label2;
    JTextField textField;
    JButton button;
    JPanel panel;
    Toolkit tk;
    Dimension dim;

    public UIControls() {
        panel = new JPanel();
        this.setTitle("UI Controls Sample");
        this.setSize(400,200);
        tk = Toolkit.getDefaultToolkit();
        dim = tk.getScreenSize();
        int xPos = (dim.width/2)-(this.getWidth()/2);
        int yPos = (dim.height/2)-(this.getHeight()/2);
        this.setLocation(xPos, yPos);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
        this.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        label1 = new JLabel("Text: ");
        label2 = new JLabel("Memory: ");
        textField = new JTextField(20);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                textField.selectAll();
                String[] oldText = new String[2];
                oldText = (label1.getText()).split(" ",2);
                label1.setText("Text: " + text);
                label2.setText("Memory: " + oldText[1]);
                if (!oldText[1].equals("")) {
                    button.setEnabled(true);
                }
            }
        });
        button = new JButton("Clear Memory");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label2.setText("Memory: ");
                button.setEnabled(false);
            }
        });
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel.add(textField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(label1);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(label2);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(button);
        if (label2.getText().equals("Memory: ")) {
            button.setEnabled(false);
        }
    }
}
