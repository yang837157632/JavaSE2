package Strategy;

/**
 * Created by Star Yang on 2016/11/29.
 */
public class Tree implements Comparable<Tree> {

    private int age;
    private Double height;

    public Tree(int age, Double height) {
        this.age = age;
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "age=" + age +
                ", height=" + height +
                '}';
    }

    @Override
    public int compareTo(Tree o) {
        if (this.height > o.getHeight()) {
            return 1;
        } else if (this.height < o.getHeight()) {
            return -1;
        } else {
            return 0;
        }
    }
}
