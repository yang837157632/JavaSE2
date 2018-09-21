package Volume_I.Chapter5;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/**
 * Created by Star Yang on 2017/1/15.
 */
public class G_FieldMethod {
    public static void main(String[] args) throws Exception {
        Class c = People.class;
        People people = (People) c.newInstance();
        Field field = c.getDeclaredField("name");
        field.setAccessible(true);
        field.set(people,"Ace");
        System.out.println(people);

        People instance = (People) c.getConstructor(String.class, int.class).newInstance("Jane", 20);
        Field[] fields = c.getDeclaredFields();
        AccessibleObject.setAccessible(fields , true);
        for (Field f: fields){
            System.out.println(f.getName() + "  " + f.get(instance));
        }
    }
}

class People{
    private String name;
    private int age;

    public People() {
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
