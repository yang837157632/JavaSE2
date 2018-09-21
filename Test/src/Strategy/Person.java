package Strategy;

import java.util.Comparator;

/**
 * Created by Star Yang on 2016/11/29.
 */
public class Person implements Comparable<Person>{

    private String name;
    private int age;
    private Comparator<Person> comparator = new PersonAgeComparator();

    public Comparator<Person> getComparator() {
        return comparator;
    }

    public void setComparator(Comparator<Person> comparator) {
        this.comparator = comparator;
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return comparator.compare(this,o);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, Comparator<Person> comparator) {
        this.name = name;
        this.age = age;
        this.comparator = comparator;
    }
}
