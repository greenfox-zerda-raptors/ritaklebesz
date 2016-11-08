/**
 * Created by Rita on 2016-11-07.
 */
public class Workshop21 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("first third fourth");
        // Add "second" to the StringBuilder (sb) between the words "first" and "third"
        // Expected outpt: first second third fourth

//        sb.insert(6, "second ");



        String insertWord = "second";
        String searchWord = "third";
        int startingIndex = searchWord.length()+1;
        if (sb.indexOf(searchWord) >= 0) {
            sb.insert(startingIndex, insertWord + " ");
        }
        System.out.println(sb.toString());
    }
}
