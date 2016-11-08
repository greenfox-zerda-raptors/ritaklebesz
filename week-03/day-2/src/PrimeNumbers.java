/**
 * Created by Rita on 2016-11-03.
 */
public class PrimeNumbers {
    public static void main(String[] args) {
        // print out prime numbers between 2 and 100
        int upperLimit = 100000;
        System.out.println(2);
        int i = 2;
        for (int j = 3; j <= upperLimit; j++) {
            while (i <= Math.floor(Math.sqrt((double) upperLimit))) {
                if (j % i != 0) {
                    if (i == Math.floor(Math.sqrt((double) j))) {
                        System.out.println(j);
                        i = 2;
                        break;
                    } else {
                        i++;
                    }
                } else {
                    i = 2;
                    break;
                }
            }
        }
    }
}
