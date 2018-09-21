package Volume_II.Chapter1;

import java.io.*;

/**
 * Created by Star Yang on 2017/4/18.
 */
public class E_Serializable {
    public static void main(String[] args) {
        Employee harry = new Employee("Harry Hacker", 35000, 1989, 10, 1);
        Employee harry2 = (Employee) harry.clone();
        harry.raiseSalary(10);
        harry2.raiseSalary(30);
        System.out.println(harry);
        System.out.println(harry2);
    }
}

class SerialCloneable implements Cloneable, Serializable {
    public Object clone() {
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bout);
            out.writeObject(this);
            out.close();

            ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bin);
            Object ret = in.readObject();
            in.close();
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
