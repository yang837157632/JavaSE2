package Volume_I.Chapter6;

import java.util.Arrays;

/**
 * Created by Star Yang on 2017/1/15.
 */
public class A_Comparable {
    public static void main(String[] args){
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("James Bond" ,20000);
        employees[1] = new Employee("Alice Green",13000);
        employees[2] = new Employee("Summer King",50000);
        Arrays.sort(employees);
        for(Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

class Employee implements Comparable<Employee>{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void raiseSalary(double percent){
        this.salary += this.salary * percent;
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(this.salary , o.salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
