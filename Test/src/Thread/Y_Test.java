package Thread;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Star Yang on 2016/11/25.
 */
public class Y_Test {

    @Test
    public void test1(){
        String a = "1";
        String b = "1";
        System.out.println(a==b);//true

        String c = new String ("1");
        String d = new String ("1");
        System.out.println(c==d);//false

        Set set = new HashSet();
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        System.out.println(set.size());//1
    }


    @Test
    public void test2(){
        String a = "1"+"";
        String b = "1"+"";
        System.out.println(a==b);//true

        String c = new String ("1"+"");
        String d = new String ("1"+"");
        System.out.println(c==d);//false

        Set set = new HashSet();
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        System.out.println(set.size());//1
    }


    @Test
    public void test3(){
        String a = testString1("1", "");
        String b = testString1("1", "");
        System.out.println(a==b);//false

        String c = testString2("1");
        String d = testString2("1");
        System.out.println(c==d);//true

        Set set = new HashSet();
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        System.out.println(set.size());//1
    }

    public String testString1(String key,String key2){
        return key+key2;
    }

    public String testString2(String key){
        return key;
    }
}
