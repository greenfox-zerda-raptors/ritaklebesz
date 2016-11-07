/**
 * Created by Rita on 2016-11-07.
 */
/* Mr. Scrooge has a sum of money 'P' that wants to invest,
and he wants to know how many years 'Y' this sum has to be kept
in the bank in order for this sum of money to amount to 'D'.

The sum is kept for 'Y' years in the bank where interest 'I' is paid yearly,
and the new sum is re-invested yearly after paying tax 'T'

Note that the principal is not taxed but only the year's accrued interest
*/
public class Money_Codewars {
    public static void main(String[] args) {
        System.out.println(calculateYears(1000, 0.05, 0.18, 1100));
    }
    public static int calculateYears(double principal, double interest,  double tax, double desired) {
        int year = 0;
        double increase = 0;
        while (principal < desired) {
            increase = principal * interest * (1-tax);
            principal += increase;
            year += 1;
        }
        return year;
    }
}
