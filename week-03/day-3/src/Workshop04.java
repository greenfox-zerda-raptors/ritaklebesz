/**
 * Created by Rita on 2016-11-04.
 */

import java.util.Arrays;

public class Workshop04 {
    public static void main(String[] args) {
        int[] s = new int[] { 1, 2, 3, 8, 5, 6 };
        // change the 8 to 4
        int i = findindex(s, 8);
        Arrays.sort(s);
        s[i] = 4;
        System.out.println(Arrays.toString(s));
        }

    public static int findindex(int[] s, int n) {
        Arrays.sort(s);
        int i = Arrays.binarySearch(s, n);
        return i;
    }
}

