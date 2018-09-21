package Volume_II.Chapter1;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by Star Yang on 2017/4/14.
 */
public class A_Text {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Shepard", 40000, 1990, 3, 15);

        try {
            PrintWriter out = new PrintWriter("employee.dat", "UTF-8");
            writeData(staff, out);
            out.close();
            Scanner in = new Scanner(new FileInputStream("employee.dat"), "UTF-8");
            Employee[] newStaff = readData(in);
            for (Employee employee : newStaff) {
                System.out.println(employee);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static void writeData(Employee[] employees, PrintWriter out) {
        out.println(employees.length);
        for (Employee employee : employees) {
            writeEmployee(out, employee);
        }
    }

    private static Employee[] readData(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
//        int n = Integer.parseInt(in.nextLine());

        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = readEmployee(in);
        }
        return employees;
    }

    public static void writeEmployee(PrintWriter out, Employee employee) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(employee.getHireday());
        out.println(employee.getName() + "|"
                + employee.getSalary() + "|"
                + calendar.get(Calendar.YEAR) + "|"
                + (calendar.get(Calendar.MONTH) + 1) + "|"
                + calendar.get(Calendar.DAY_OF_MONTH));
    }

    public static Employee readEmployee(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        int year = Integer.parseInt(tokens[2]);
        int month = Integer.parseInt(tokens[3]);
        int day = Integer.parseInt(tokens[4]);
        return new Employee(name, salary, year, month, day);
    }
}

class Employee extends SerialCloneable {
    private String name;
    private double salary;
    private Date hireday;
    public static int NAME_SIZE = 12;
    public static int RECORD_SIZE = 44;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireday = new GregorianCalendar(year, month - 1, day).getTime();
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireday() {
        return hireday;
    }

    public void raiseSalary(double percent) {
        salary = (1 + percent / 100) * salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireday=" + hireday +
                '}';
    }
}