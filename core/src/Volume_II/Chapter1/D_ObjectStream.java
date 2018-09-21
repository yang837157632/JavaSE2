package Volume_II.Chapter1;

import java.io.*;

/**
 * Created by Star Yang on 2017/4/17.
 */
public class D_ObjectStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        Manager manager = new Manager("Harry Hacker", 50000, 1989, 10, 1);
        manager.setSecretary(staff[0]);
        staff[1] = manager;
        Manager manager2 = new Manager("Tony Shepard", 40000, 1990, 3, 15);
        manager2.setSecretary(staff[0]);
        staff[2] = manager2;

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.dat"));
        out.writeObject(staff);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.dat"));
        Employee[] newStaff = (Employee[]) in.readObject();
        newStaff[1].raiseSalary(50);
        for (Employee e : newStaff)
            System.out.println(e);
    }
}

class Manager extends Employee {
    private Employee secretary;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }

    public Employee getSecretary() {
        return secretary;
    }

    public void setSecretary(Employee secretary) {
        this.secretary = secretary;
    }

    @Override
    public String toString() {
        return super.toString() + " Manager{" +
                "secretary=" + secretary +
                '}';
    }
}
