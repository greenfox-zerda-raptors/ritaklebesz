import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rita on 2016-11-07.
 */
public class Workshop17 {

        // Implement trimAll(..)
        // Expected output:
        // "first"
        // "second"
        // "third"
        // "fourth"
        // "fifth"

        static void trimAll(List<String> strings) {
            for (String string : strings) {
                strings.set(strings.indexOf(string), string.trim());
            }
        }

    public static void main(String... args){
        List<String> strList = new ArrayList<String>(Arrays.asList("   first", "second   ", "  third ", "fourth", "    fifth "));
        trimAll(strList);
        for (String str : strList) {
            System.out.format("\"%s\"%n", str);
        }
    }
}
