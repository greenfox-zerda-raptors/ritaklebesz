/**
 * Created by Rita on 2016-11-04.
 */
public class Workshop21 {
    public static void main(String[] args) {
        // create a recursive function that returns it's input factorial

        System.out.println(recursiveFactorial(3));
    }

    public static int recursiveFactorial(int z) {
        if (z == 1) {
            return 1;}
        return z * recursiveFactorial(z - 1);
    }
}
