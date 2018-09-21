package Volume_I.Chapter12;

import Volume_I.Chapter12.Info.Employee;
import Volume_I.Chapter12.Info.Manager;
import Volume_I.Chapter12.Info.Pair;

/**
 * Created by Star Yang on 2017/2/19.
 */
public class C_Wildcards {
    public static void main(String[] args) {
        Manager ceo = new Manager("Christoper", 35, 100000);
        Manager cto = new Manager("Meg", 40, 200000);
        Pair<Manager> buddies = new Pair<Manager>(ceo, cto);
        printBuddies(buddies);

        ceo.setBonus(150000);
        cto.setBonus(250000);
        Manager[] managers = {ceo, cto};

        Pair<Employee> result = new Pair<Employee>();
        minmaxBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName() + " , second: " + result.getLast().getName());
        maxminBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName() + " , second: " + result.getLast().getName());
    }

    public static void printBuddies(Pair<? extends Employee> pair) {
        Employee first = pair.getFirst();
        Employee last = pair.getLast();
        System.out.println(first.getName() + " and " + last.getName() + " are buddies");
    }

    public static void minmaxBonus(Manager[] a, Pair<? super Manager> result) {
        if (a == null || a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.getBonus() < a[i].getBonus()) min = a[i];
            if (max.getBonus() > a[i].getBonus()) max = a[i];
        }
        result.setFirst(min);
        result.setLast(max);
    }

    public static void maxminBonus(Manager[] a, Pair<? super Manager> result) {
        minmaxBonus(a, result);
//        ArrayClg.swapHelper(result);
        ArrayClg.swap(result);
    }
}

class ArrayClg {
    public static boolean hasNulls(Pair<?> pair) {
        return pair.getFirst() == null || pair.getLast() == null;
    }

    public static void swap(Pair<?> pair) {
        swapHelper(pair);
    }

    public static <T> void swapHelper(Pair<T> pair) {
        T t = pair.getFirst();
        pair.setFirst(pair.getLast());
        pair.setLast(t);
    }
}
