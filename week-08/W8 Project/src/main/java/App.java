import com.greenfox.ritaklebesz.ToDo;

/**
 * Created by Rita on 2016-11-17.
 */
public class App {
    public static void main(String[] args) {
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
