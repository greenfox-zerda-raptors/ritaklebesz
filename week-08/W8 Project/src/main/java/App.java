import com.greenfox.ritaklebesz.ToDo;

import java.sql.SQLException;

/**
 * Created by Rita on 2016-11-17.
 */
public class App {
    public static void main(String[] args) throws SQLException {
        ToDo tasks = new ToDo();
        System.out.println("CLI Todo application");
        System.out.println("====================\n");
        tasks.printMenu();
        while (true) {
            System.out.println("\nWhat would you like to do next?");
            tasks.inputHandler();
            tasks.commandManager();
        }
    }
}
