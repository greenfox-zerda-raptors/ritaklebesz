/**
 * Created by Rita on 2016-11-07.
 */
public class Workshop21 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("first third fourth");
        // Add "second" to the StringBuilder (sb) between the words "first" and "third"
        // Expected outpt: first second third fourth

//        searchWord ="third"
//        find it ge 0len searchWord
        sb.insert(6, "second ");
//        sb.insert()

        System.out.println(sb.toString());
    }
}
