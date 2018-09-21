package Thread;

import java.util.Random;

/**
 * Created by Star Yang on 2016/11/23.
 */
public class F_ThreadLocal {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
//    private static ThreadLocal<ThreadLocalData> threadLocalObject = new ThreadLocal<ThreadLocalData>();

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Integer data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " has put data: " + data);
                    threadLocal.set(data);
                    ThreadLocalData.getThreadInstance().setName("name" + data);
                    ThreadLocalData.getThreadInstance().setAge(data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    public static class A {
        public void get() {
            Integer data = threadLocal.get();
            System.out.println("Class A from " + Thread.currentThread().getName() + " get data: " + data);
            System.out.println("Class A from " + Thread.currentThread().getName() + "......" + ThreadLocalData.getThreadInstance().toString());
        }
    }

    public static class B {
        public void get() {
            Integer data = threadLocal.get();
            System.out.println("Class B from " + Thread.currentThread().getName() + " get data: " + data);
            System.out.println("Class B from " + Thread.currentThread().getName() + "......" + ThreadLocalData.getThreadInstance().toString());
        }
    }
}

class ThreadLocalData {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private ThreadLocalData() {
    }

    private static ThreadLocal<ThreadLocalData> map = new ThreadLocal<ThreadLocalData>();

    public static ThreadLocalData getThreadInstance() {
        ThreadLocalData instance = map.get();
        if (instance == null) {
            System.out.println("**********");
            instance = new ThreadLocalData();
            map.set(instance);
        }
        return instance;
    }

    @Override
    public String toString() {
        return " ThreadLocalData{" + "age=" + age + ", name=" + name + "}";
    }
}

