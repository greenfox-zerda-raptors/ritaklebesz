import javax.swing.*;

/**
 * Created by Rita on 2016-12-06.
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new Board());
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
