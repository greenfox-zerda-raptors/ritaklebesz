/**
 * Created by Rita on 2016-11-03.
 */
public class Workshop28 {
    public static void main(String[] args) {
        int z = 13;
        // if z is between 10 and 20 print 'Sweet!'
        // if less than 10 print 'More!',
        // if more than 20 print 'Less!'
        if (z <= 20 && 10 <= z) {
            System.out.println("Sweet!");
        } else if (10 < z) {
            System.out.println("More!");
        } else {
            System.out.println("Less!");
        }
    }
}
