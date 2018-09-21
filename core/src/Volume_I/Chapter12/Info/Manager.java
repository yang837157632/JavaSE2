package Volume_I.Chapter12.Info;

/**
 * Created by Star Yang on 2017/2/19.
 */
public class Manager extends Employee {
    private double bonus;

    public Manager(String name, int age, double bonus) {
        super(name, age);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + getName() + '\'' +
                ", age='" + getAge() + '\'' +
                "bonus=" + bonus +
                '}';
    }
}
