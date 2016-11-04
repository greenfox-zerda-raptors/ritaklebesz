/**
 * Created by Rita on 2016-11-04.
 */
public class Workshop19 {
    public static void main(String[] args) {
        // create a function that returns it's input factorial

        System.out.println(factorial(3));
    }
    public static int factorial(int z) {
        int fact = 1;
        for (int j = z; j > 0; j--) {
            fact *= j;
        }
        return fact;
    }
}
