package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Star Yang on 2016/11/24.
 */
public class J_Lock {

    public static void main(String[] args) {
        final Outputer outputer = new Outputer();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        outputer.output("abcdefg");
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                        outputer.output("123456789");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }




    public static class Outputer {
        Lock lock = new ReentrantLock();

        public void output(String name) {
            lock.lock();
            try {
                for (int i = 0; i < name.length(); i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            } finally {
                lock.unlock();
            }
        }
    }

}
