package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public final class BirthdayWithJavaUtilDate implements BirthdayCalculator<Date> {

    @Override
    public Date parseDate(String str) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public String printMonthAndDay(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String reportDate = df.format(date);
        String result = reportDate.substring(5, 7) + ". " + reportDate.substring(8) + ".";
        return result;
    }

    @Override
    public boolean isAnniversaryToday(Date date) {
        String dateString = printMonthAndDay(date);
        DateFormat dateFormat = new SimpleDateFormat("MM. dd.");
        Date today = new Date();
        String todayString = dateFormat.format(today);
        return dateString.equals(todayString);
    }

    @Override
    public int calculateAgeInYears(Date birthday) {
        DateFormat dateFormatYear = new SimpleDateFormat("yyyy");
        DateFormat dateFormatMonth = new SimpleDateFormat("MM");
        DateFormat dateFormatDay = new SimpleDateFormat("dd");
        Date today = new Date();
        int birthYear = Integer.valueOf(dateFormatYear.format(birthday));
        int birthMonth = Integer.valueOf(dateFormatMonth.format(birthday));
        int birthDay = Integer.valueOf(dateFormatDay.format(birthday));
        int thisYear = Integer.valueOf(dateFormatYear.format(today));
        int thisMonth = Integer.valueOf(dateFormatMonth.format(today));
        int thisDay = Integer.valueOf(dateFormatDay.format(today));
        if (birthMonth < thisMonth) {
            return thisYear - birthYear;
        } else if (birthMonth == thisMonth && birthDay <= thisDay) {
            return thisYear - birthYear;
        } else {
            return thisYear - birthYear - 1;
        }
    }

    @Override
    public int calculateDaysToNextAnniversary(Date date) {
        // TODO - the number of days remaining to the next anniversary of 'date' (e.g. if tomorrow, return 1)
        GregorianCalendar today = new GregorianCalendar();
        DateFormat dateFormatYear = new SimpleDateFormat("yyyy");
        DateFormat dateFormatMonth = new SimpleDateFormat("MM");
        DateFormat dateFormatDay = new SimpleDateFormat("dd");
        int birthYear = Integer.valueOf(dateFormatYear.format(date));
        int birthMonth = Integer.valueOf(dateFormatMonth.format(date));
        int birthDay = Integer.valueOf(dateFormatDay.format(date));
        GregorianCalendar birthday = new GregorianCalendar(birthYear, birthMonth - 1, birthDay);
        birthday.add(GregorianCalendar.YEAR, calculateAgeInYears(date));
        int diffDays = 0;
        if (today.before(birthday)) {
            while (today.before(birthday)) {
                today.add(GregorianCalendar.DAY_OF_MONTH, 1);
                diffDays++;
            }
        } else if (today.after(birthday)) {
            birthday.add(GregorianCalendar.YEAR, 1);
            while (today.before(birthday)) {
                today.add(GregorianCalendar.DAY_OF_MONTH, 1);
                diffDays++;
            }
        }
        return diffDays;
    }

    public static void main(String[] args) {
        new BirthdayWithJavaUtilDate().run();
    }

    private void run() {

        print("Birthday with java.util.Date.");
        String birthdayStr = readInput("What day were you born (yyyy-mm-dd)?");

        Date birthdayDate = parseDate(birthdayStr);
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
