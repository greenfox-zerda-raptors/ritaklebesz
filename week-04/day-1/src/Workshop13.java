import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Rita on 2016-11-07.
 */
public class Workshop13 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("first", "second", "third", "fourth", "fifth"));
        // Print all elements of the list using a for loop and an Iterator
        Iterator<String> it = list.iterator();
        for (; it.hasNext(); ) {
            System.out.println(it.next());
        }
    }
}
