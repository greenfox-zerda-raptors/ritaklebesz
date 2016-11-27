import com.greenfox.ritaklebesz.GUI;

import javax.swing.*;

/**
 * Created by Rita on 2016-11-17.
 */
public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        });
    }
//    public static void main(String[] args) {
//        NewerToDo tasks = new NewerToDo();
//        System.out.println("CLI Todo application");
//        System.out.println("====================\n");
//        tasks.printMenu();
//        while (true) {
//            System.out.println("\nWaiting for command...");
//            tasks.inputHandler();
//            tasks.commandManager();
//        }
//    }
}
