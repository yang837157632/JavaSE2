package Volume_I.Chapter6;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Star Yang on 2017/1/17.
 */
public class B_Clone {
    public static void main(String[] args){
        try {
            Department original = new Department("CMS" , 2000000);
            original.setHireday(2001,10,12);
            Department copy = original.clone();
            copy.raiseSalary(30);
            copy.setHireday(2017,1,1);
            System.out.println(original+"\n"+copy);

            int[] numbers = {1,2,3,4,5,6,7};
            int[] clone = numbers.clone();
            clone[3] = 500;
            System.out.println(Arrays.toString(numbers)+"\n"+Arrays.toString(clone));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class Department implements Cloneable{
    private String name;
    private double salary;
    private Date hireday;

    public Department(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Department clone() throws CloneNotSupportedException{
        Department department = (Department) super.clone();
        department.hireday = (Date) hireday.clone();
        return department;
    }

    public void setHireday(int year , int month , int day){
        hireday = new GregorianCalendar(year , month-1 , day).getTime();
    }

    public void raiseSalary(double byPercent){
        salary += (salary*byPercent/100);
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireday=" + hireday +
                '}';
    }
}
