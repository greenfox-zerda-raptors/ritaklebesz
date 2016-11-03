/**
 * Created by Rita on 2016-11-03.
 */
public class Workshop22 {
    public static void main(String[] args) {
        String first = "I am the first string!";
        String second = "I think I'm longer than first..";
        // Decide if "first" string is longer than "second" string and store it in a variable
        // Print the value of the variable
        String comparisonResult = "";
        if (first.length() >= second.length()) {
            comparisonResult = "The first string is longer.";
        } else {
            comparisonResult = "The second string is longer";
        }
        System.out.println(comparisonResult);
    }
}
