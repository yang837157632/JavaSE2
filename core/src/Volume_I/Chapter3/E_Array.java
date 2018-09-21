package Volume_I.Chapter3;

import java.util.Arrays;

/**
 * Created by Star Yang on 2017/1/8.
 */
public class E_Array {
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,9,10};

        int[] a = array;
        System.out.println(Arrays.toString(a));

        int[] b = Arrays.copyOf(array,a.length);
        System.out.println(Arrays.toString(b));

        int[] c = Arrays.copyOf(array,20);
        System.out.println(Arrays.toString(c));

        System.out.println(Arrays.equals(a,b));
        System.out.println(a==b);
    }
}
