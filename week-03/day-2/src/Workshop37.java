/**
 * Created by Rita on 2016-11-03.
 */
public class Workshop37 {
    public static void main(String[] args) {
        // Write a program which has this output
        //# # # # # # #
        //  # # # # # # #
        // # # # # # # #
        //  # # # # # # #
        // # # # # # # #
        //  # # # # # # #
        // # # # # # # #
        // The # character should be replacable, hence store it in a variable
        char c = 35;
        int n = 7;
        String str = "";
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    str = new StringBuilder(str).append(c + " ").toString();
                }
            } else {
                str = "  ";
                for (int j = 0; j < n; j++) {
                    str = new StringBuilder(str).append(c + " ").toString();
                }
            }
            System.out.println(str);
            str = "";
        }

        System.out.println();
    }
}
