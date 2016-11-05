import java.util.Scanner;

/**
 * Created by Rita on 2016-11-04.
 */
public class Workshop22 {
    static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {
        // create a function which prints the input String parameters (can have multiple number of arguments)
        print();
    }
    public static void print(String... strings) {
        String outPut = "";
        while (! outPut.equalsIgnoreCase("q")) {
            System.out.println(outPut);
            System.out.println("Type in something, and I will repeat it. Or press q to quit.");
            outPut = userInput.nextLine();
        }
    }
}
