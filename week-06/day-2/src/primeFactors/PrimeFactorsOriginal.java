package primeFactors;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rita on 2016-11-22.
 */
public class PrimeFactorsOriginal {
    public static List<Integer> generate(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        int candidate = 2;
        while (n>1) {
            while (n % candidate == 0){
                primes.add(candidate);
                n /= candidate;
            }
            candidate++;
        }
        return primes;
    }
}
