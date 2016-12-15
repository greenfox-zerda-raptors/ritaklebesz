import com.greenfox.ritaklebesz.GIUToDo;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 * Created by Rita on 2016-12-15.
 */
public class GUIApp {
    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame();
        frame.add(new GIUToDo());
        frame.setTitle("ToDo App");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width / 2) - (frame.getWidth() / 2);
        int yPos = (dim.height / 2) - (frame.getHeight() / 2);
        frame.setLocation(xPos, yPos);
    }
}
