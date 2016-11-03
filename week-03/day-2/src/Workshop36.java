/**
 * Created by Rita on 2016-11-03.
 */
public class Workshop36 {
    public static void main(String[] args) {
        // Write a program which has this output
        // # # # # #
        // # # # # #
        // # # # # #
        // # # # # #
        // # # # # #
        // The # character should be replacable, hence store it in a variable
        char c = 35;
        int n = 5;
        String str = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                str = new StringBuilder(str).append(c + " ").toString();
            }
            System.out.println(str);
            str = "";
        }
    }
}
