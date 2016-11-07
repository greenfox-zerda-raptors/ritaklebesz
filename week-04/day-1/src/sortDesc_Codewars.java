import java.util.Arrays;

/**
 * Created by Rita on 2016-11-07.
 */
/*Your task is to make a function that can take any
non-negative integer as a argument and return it with
it's digits in descending order.
Descending order means that you take the highest digit
and place the next highest digit immediately after it. */

public class sortDesc_Codewars {
    public static void main(String[] args) {
        System.out.println(sortDesc(132));
    }
    public static int sortDesc(final int num) {
        String numStr = Integer.toString(num);
        char[] numArray = new char[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            numArray[i] = numStr.charAt(i);
        }
        Arrays.sort(numArray);
        String sorted = new String(numArray);
        StringBuilder descSB = new StringBuilder();
        for (int j = sorted.length()-1; j >= 0; j--) {
            descSB.append(sorted.charAt(j));
        }
        String descStr = descSB.toString();
        return Integer.parseInt(descStr);
    }
}
