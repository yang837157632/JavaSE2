package Thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Star Yang on 2016/11/23.
 */
public class E_ThreadScopeShareData {

//    private static int data = 0;
    private static Map<Thread, Integer> threadData = new HashMap<Thread, Integer>();

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " put data: " + data);
                    threadData.put(Thread.currentThread(), data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    public static class A {
        public void get() {
            int data = threadData.get(Thread.currentThread());
            System.out.println("Class A from " + Thread.currentThread().getName() + " get Data: " + data);
        }
    }


    public static class B {
        public void get() {
            int data = threadData.get(Thread.currentThread());
            System.out.println("Class B from " + Thread.currentThread().getName() + " get Data: " + data);
        }
    }
}
