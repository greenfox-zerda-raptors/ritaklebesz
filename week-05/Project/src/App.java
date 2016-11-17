import com.greenfox.ritaklebesz.NewToDo;

/**
 * Created by Rita on 2016-11-17.
 */
public class App {
    public static void main(String[] args) {
        NewToDo tasks = new NewToDo();
        System.out.println("CLI Todo application");
        System.out.println("====================\n");
        tasks.printMenu();
        while (true) {
            System.out.println("\nWaiting for command...");
            tasks.inputHandler();
            tasks.commandManager();
        }
    }
}
