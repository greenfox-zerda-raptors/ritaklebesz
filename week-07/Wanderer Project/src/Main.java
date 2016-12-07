import javax.swing.*;

/**
 * Created by Rita on 2016-12-06.
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Board board = new Board();
        frame.add(board);
        frame.addKeyListener(board);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
