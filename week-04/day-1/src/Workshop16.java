import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rita on 2016-11-07.
 */
public class Workshop16 {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7 ));
        // Fix this code fragment! It should remove every even number from the list.
        ArrayList<Integer> alToRemove = new ArrayList<>();

        for(int element : al){
            if(element % 2 == 0){
                alToRemove.add(element);
            }
        }
        al.removeAll(alToRemove);
        System.out.println(al);
    }
}
