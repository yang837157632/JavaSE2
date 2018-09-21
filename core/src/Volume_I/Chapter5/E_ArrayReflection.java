package Volume_I.Chapter5;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Star Yang on 2017/1/15.
 */
public class E_ArrayReflection {
    public static void main(String[] args){
        int[] a = {1,2,3};
        int[] b = (int[])arrayCopyOf(a,10);
        System.out.println(Arrays.toString(b));

        String[] s = {"Ace" , "Bob" , "Candy"};
        s= (String[])arrayCopyOf(s,10);
        System.out.println(Arrays.toString(s));
    }

    public static Object arrayCopyOf(Object object , int newLength){
        Class c = object.getClass();
        if(!c.isArray()) return null;
        Class type = c.getComponentType();
        int length = Array.getLength(object);
        Object newObject = Array.newInstance(type , newLength);
        System.arraycopy(object,0,newObject,0,Math.min(length, newLength));
        return newObject;
    }
}
