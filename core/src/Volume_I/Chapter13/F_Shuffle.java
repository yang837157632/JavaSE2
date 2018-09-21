package Volume_I.Chapter13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Star Yang on 2017/3/13.
 */
public class F_Shuffle {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= 49; i++)
            numbers.add(i);
        System.out.println(numbers);

        Collections.shuffle(numbers);
        System.out.println(numbers);

        List<Integer> winningCombination = numbers.subList(0, 6);
        Collections.sort(winningCombination);
        System.out.println(winningCombination);
    }
}
