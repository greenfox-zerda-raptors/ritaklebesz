import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Rita on 2016-11-07.
 */
public class Workshop14 {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>(Arrays.asList("kuty", "macsk", "kacs", "rók"));
        // Add "a" to every string in al. Use an iterator!
        Iterator<String> it = al.iterator();
        for (; it.hasNext(); ) {
            String item = it.next();
            al.set(al.indexOf(item), item + "a");
        }

        System.out.println(al);
    }
}
