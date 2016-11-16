import com.greenfox.bx.CreditCardReservation;

import java.util.ArrayList;

/**
 * Created by Rita on 2016-11-16.
 */
public class AppCreditCardReservation {
    final static String[] lsDow = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

    public static void main(String[] args) {
        ArrayList<CreditCardReservation> bookings = new ArrayList<CreditCardReservation>();
        int ct = 10;

        for (int i = 0; i < ct; i++) {
            bookings.add(new CreditCardReservation(AppReservation.randomDow(10), 0, "DEF" + i, AppCreditCard.random16()));
        }

        for (CreditCardReservation iBooking : bookings) {
            System.out.println(iBooking.toString());
        }
    }
}
