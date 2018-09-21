package Thread;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Star Yang on 2016/11/24.
 */
public class K_ReadWriteLock {

    public static void main(String[] args) {
        final ReadWriteLockQueue queue = new ReadWriteLockQueue();
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        queue.get();
                    }
                }
            }).start();
        }

        for (int j = 0; j < 3; j++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        queue.set(new Random().nextInt());
                    }
                }
            }).start();
        }

    }
}

class ReadWriteLockQueue {
    private Object data = null;
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void get() {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " be ready to read data!");
            Thread.sleep(new Random().nextInt(1000));
            System.out.println(Thread.currentThread().getName() + " have read data: " + data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void set(Object data) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " be ready to write data!");
            Thread.sleep(new Random().nextInt(1000));
            this.data = data;
            System.out.println(Thread.currentThread().getName() + " have write data: " + data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
