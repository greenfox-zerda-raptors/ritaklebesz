import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ArrayList;
/**
 * Created by Rita on 2016-11-07.
 */
public class Workshop05 {
    public static void main(String[] args) {
        ArrayList<Integer> numList = new ArrayList<Integer>(Arrays.asList(12, 1, 532, 23, 0, 7, 54, 32));
        // Copy every element of "numList" to an Array
        int[] numArray = new int[numList.size()];
        int i = 0;
        for (int n : numList) {
            numArray[i] = n;
            i++;
        }
        System.out.println(Arrays.toString(numArray));
        System.out.println("\n\nother way\n");

        Integer list2[] = new Integer[numList.size()];
        list2 = numList.toArray(list2);
//        for (Integer number : list2) {
//            System.out.println("Number = " + number);
//        }
        System.out.println(Arrays.toString(list2));

    }
}
