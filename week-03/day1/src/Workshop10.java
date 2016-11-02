/**
 * Created by Rita on 2016-11-02.
 */
public class Workshop10 {
    public static void main(String[] args) {
        int j1 = 10;
        int j2 = 3;
        // tell if j1 is between j2 squared and j2 cubed
        int j2Squared = j2*j2;
        int j2Cubed = j2*j2*j2;
        boolean b = j2Squared < j1 && j2Cubed > j1;
        System.out.println(b);
    }
}
