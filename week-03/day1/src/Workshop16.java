/**
 * Created by Rita on 2016-11-02.
 */
public class Workshop16 {
    public static void main(String[] args) {
        String n = "The result is: ";
        int a = 2;
        int b = 3;
        // concat the product of a and b to the n string
        int result = a+b;
        String resultString = Integer.toString(result);
        System.out.println(n.concat(resultString));
    }
}
