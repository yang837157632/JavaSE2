package Volume_I.Chapter12;

import Volume_I.Chapter12.Info.Pair;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Star Yang on 2017/2/16.
 */
public class B_Extends {
    public static void main(String[] args) {
        GregorianCalendar[] birthdays = {
                new GregorianCalendar(1992, Calendar.SEPTEMBER, 17),
                new GregorianCalendar(1994, Calendar.JANUARY, 9),
                new GregorianCalendar(1993, Calendar.MARCH, 10),
                new GregorianCalendar(1990, Calendar.OCTOBER, 14),
                new GregorianCalendar(1991, Calendar.AUGUST, 20),
        };

        Pair<GregorianCalendar> mm = ArrayBlg.minmax(birthdays);
        System.out.println("min : " + mm.getFirst().getTime() + "\t" + mm.getFirst().get(Calendar.MONTH));
        System.out.println("max : " + mm.getLast().getTime() + "\t" + mm.getLast().get(Calendar.MONTH));
    }
}

class ArrayBlg {
    public static <T extends Comparable & Serializable> Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<T>(min, max);
    }
}
