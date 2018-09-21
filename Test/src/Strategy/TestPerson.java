package Strategy;

import java.util.Arrays;

/**
 * Created by Star Yang on 2016/11/29.
 */
public class TestPerson {

    public static void main(String[] args){
        Person[] persons = new Person[6];

        for(int i=0;i<6;i++){
            StringBuffer name=new StringBuffer();
            for(int j=0;j<(int)(Math.random()*10)+1;j++){
                name.append((char)((int)(Math.random()*26)+97));
            }
//            persons[i] = new Person(name.toString(),(int)(Math.random()*100));
            persons[i] = new Person(name.toString(),(int)(Math.random()*100),new PersonNameComparator());
        }

        for(int i=0;i<6;i++){
            System.out.println(persons[i]);
        }

        Arrays.sort(persons);
        System.out.println();

        for(int i=0;i<6;i++){
            System.out.println(persons[i]);
        }
    }
}
