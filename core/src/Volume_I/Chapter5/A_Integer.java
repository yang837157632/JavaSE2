package Volume_I.Chapter5;

/**
 * Created by Star Yang on 2017/1/14.
 */
public class A_Integer {
    public static void main(String[] args){
        Integer integer = new Integer(100);
        int i = integer.intValue();
        System.out.println("Integer to int\t"+i);

        int number = 100;
        String s = Integer.toString(number);
        String s2 = Integer.toString(number,8);
        System.out.println("int to String\t"+s);
        System.out.println("int to String\t"+s2);

        String ss = new String("100");
        int a= Integer.parseInt(ss);
        int b = Integer.parseInt(ss,8);
        System.out.println("String to int\t"+a);
        System.out.println("String to int\t"+b);

        Integer c = Integer.valueOf(ss);
        Integer d = Integer.valueOf(ss,8);
        System.out.println("String to Integer\t"+c);
        System.out.println("String to Integer\t"+d);
    }
}