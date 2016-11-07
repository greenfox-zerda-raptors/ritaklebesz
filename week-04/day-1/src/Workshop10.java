import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rita on 2016-11-07.
 */
public class Workshop10 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("first", "sixth", "third", "fourth", "fifth"));
        // Accidentally I added "sixth" instead of "second"! Your task is to swap "sixth" with "second"
        list.set(list.indexOf("sixth"), "second");
        System.out.println(list);
    }
}
