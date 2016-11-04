import java.util.Arrays;

/**
 * Created by Rita on 2016-11-04.
 */
public class Workshop14 {
    public static void main(String[] args) {
        // Reverse the order of ah
        int[] ah = new int[]  { 3, 4, 5, 6, 7 };
        int temp = 0;
        int j = ah.length-1;
        for(int i=0;i<ah.length/2;i++){
            temp = ah[j];
            ah[j] = ah[i];
            ah[i] = temp;
            j--;
        };

        System.out.println(Arrays.toString(ah));
    }
}
