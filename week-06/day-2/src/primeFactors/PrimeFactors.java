package primeFactors;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rita on 2016-11-22.
 */
public class PrimeFactors {
    public static List<Integer> generate(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        for (int candidate = 2; n>1; candidate++) {
            for (; n % candidate == 0; n /= candidate){
                primes.add(candidate);
            }
        }
        return primes;
    }
}
