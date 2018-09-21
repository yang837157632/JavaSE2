package Volume_I.Chapter4;

import org.junit.Test;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by Star Yang on 2017/1/9.
 */
public class A_Calendar {
    public static void main(String[] args) {
        Locale.setDefault(Locale.UK);
        GregorianCalendar d = new GregorianCalendar();
        int today = d.get(Calendar.DAY_OF_MONTH);
        int month = d.get(Calendar.MONTH);

        d.set(Calendar.DAY_OF_MONTH, 1);
        int weekday = d.get(Calendar.DAY_OF_WEEK);

        int firstDayOfWeek = d.getFirstDayOfWeek();
        int indent = 0;
        while (weekday != firstDayOfWeek) {
            indent++;
            d.add(Calendar.DAY_OF_MONTH, -1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }

        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
        do {
            System.out.printf("%6s", weekdayNames[weekday]);
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        } while (weekday != firstDayOfWeek);
        System.out.println();

        for (int i = 0; i < indent; i++) System.out.print("      ");

        d.set(Calendar.DAY_OF_MONTH, 1);
        do {
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%4d", day);

            if (day == today) System.out.print("* ");
            else System.out.print("  ");

            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
            if (weekday == firstDayOfWeek) System.out.println();
        } while (d.get(Calendar.MONTH) == month);

        if (weekday != firstDayOfWeek) System.out.println();
    }

    @Test
    public void test1() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(1999, 11, 31);
        GregorianCalendar gregorianCalendar3 = new GregorianCalendar(1999, Calendar.DECEMBER, 31);
        GregorianCalendar gregorianCalendar4 = new GregorianCalendar(1999, Calendar.DECEMBER, 31, 23, 59, 59);

        System.out.println(gregorianCalendar.getTime());
        System.out.println(gregorianCalendar2.getTime());
        System.out.println(gregorianCalendar3.getTime());
        System.out.println(gregorianCalendar4.getTime());
    }

    @Test
    public void test2() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        int month = gregorianCalendar.get(Calendar.MONTH);
        int day = gregorianCalendar.get(Calendar.DAY_OF_MONTH);
        int weekday = gregorianCalendar.get(Calendar.DAY_OF_WEEK);

        System.out.println(month);
        System.out.println(day);
        System.out.println(weekday);
    }

    @Test
    public void test3() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(Calendar.YEAR, 2012);
        gregorianCalendar.set(Calendar.MONTH, Calendar.SEPTEMBER);
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, 12);
        System.out.println(gregorianCalendar.getTime());

        gregorianCalendar.set(2000, Calendar.MARCH, 8);
        System.out.println(gregorianCalendar.getTime());

        gregorianCalendar.add(Calendar.MONTH, 3);
        //The second parameter can be a negative,then the calendar moved backwards
        System.out.println(gregorianCalendar.getTime());
    }
}
