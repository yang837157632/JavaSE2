package Volume_I.Chapter13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Star Yang on 2017/3/11.
 */
public class B_HashSet {
    public static void main(String[] args) {
        Set<String> words = new HashSet<String>();
        long totalTime = 0;

        int i = 0;
        while (i < 10000) {
            String word = Integer.toHexString(i);
            long callTime = System.currentTimeMillis();
            words.add(word);
            callTime = System.currentTimeMillis() - callTime;
            i++;
            totalTime += callTime;
        }

        Iterator<String> iterator = words.iterator();
        for (int j = 0; j <= 20 && iterator.hasNext(); j++) {
            System.out.println(iterator.next());
        }
        System.out.println("...");
        System.out.println(words.size() + " distinct words.. " + totalTime + "milliseconds");
    }
}
