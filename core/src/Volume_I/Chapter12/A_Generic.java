package Volume_I.Chapter12;

import Volume_I.Chapter12.Info.Pair;

/**
 * Created by Star Yang on 2017/2/15.
 */
public class A_Generic {
    public static void main(String[] args) {
        String[] words = {"Love", "Star", "Alice", "Beautiful","Youth", "Wonderful"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min : " + mm.getFirst());
        System.out.println("max : " + mm.getLast());
    }
}

class ArrayAlg {
    public static Pair<String> minmax(String[] a) {
        if (a == null || a.length == 0) return null;
        String max = a[0];
        String min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<String>(min, max);
    }
}
