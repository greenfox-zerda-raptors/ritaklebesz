package date;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.util.Scanner;

/**
 * Created by kicsen on 2016. 11. 30..
 */
public class BirthdayWithJodaTime implements BirthdayCalculator<LocalDate> {

    @Override
    public LocalDate parseDate(String str) {
        String[] dateArray = str.split("-");
        LocalDate date = new LocalDate(Integer.valueOf(dateArray[0]), Integer.valueOf(dateArray[1]), Integer.valueOf(dateArray[2]));
        return date;
    }

    @Override
    public String printMonthAndDay(LocalDate date) {
        return (date.getMonthOfYear() < 10 ? "0" + date.getMonthOfYear() : date.getMonthOfYear()) + ". " +
                (date.getDayOfMonth() < 10 ? "0" + date.getDayOfMonth() : date.getDayOfMonth()) + ".";
    }

    @Override
    public boolean isAnniversaryToday(LocalDate date) {
        LocalDate today = new LocalDate();
        return printMonthAndDay(today).equals(printMonthAndDay(date));
    }

    @Override
    public int calculateAgeInYears(LocalDate birthday) {
        LocalDate today = new LocalDate();
        if (today.getMonthOfYear() < birthday.getMonthOfYear() || today.getMonthOfYear() == birthday.getMonthOfYear() && today.getDayOfMonth() < birthday.getDayOfMonth()) {
            return today.getYear() - birthday.getYear() - 1;
        }
        return today.getYear() - birthday.getYear();
    }

    @Override
    public int calculateDaysToNextAnniversary(LocalDate date) {
        LocalDate today = new LocalDate();
        LocalDate birthday = date.plusYears(calculateAgeInYears(date));
        Days d;
        int days = 0;
        if (today.isBefore(birthday)) {
            d = Days.daysBetween(today, birthday);
            days = d.getDays();
        } else if (today.isAfter(birthday)) {
            birthday = birthday.plusYears(1);
            d = Days.daysBetween(today, birthday);
            days = d.getDays();
        }
        return days;
    }

    public static void main(String[] args) {
        new BirthdayWithJodaTime().run();
    }

    private void run() {

        print("Birthday with java.util.Date.");
        String birthdayStr = readInput("What day were you born (yyyy-mm-dd)?");

        LocalDate birthdayDate = parseDate(birthdayStr);
        print("Your birthday: " + printMonthAndDay(birthdayDate));

        if (isAnniversaryToday(birthdayDate)) {
            int ageInYears = calculateAgeInYears(birthdayDate);
            print("Congratulations! Today is your " + ageInYears + "th birthday!");
        } else {
            int daysLeft = calculateDaysToNextAnniversary(birthdayDate);
            print("You have to wait only " + daysLeft + " days for your next birthday.");
        }
    }

    private void print(String line) {
        System.out.println(line);
    }

    private String readInput(String message) {
        System.out.print(message + ": ");
        return input.nextLine();
    }

    private final Scanner input = new Scanner(System.in, "UTF-8");
}
