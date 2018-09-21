package Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Star Yang on 2016/11/24.
 */
public class M_Communication {
    public static void main(String[] args){
        final Business business = new Business();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=50;i++){
                    business.sub(i);
                }
            }
        }).start();

        for (int i=1;i<=50;i++){
            business.main(i);
        }
    }

    public static class Business{

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        private boolean shouldSub = false;

        public void main(int i){
            lock.lock();
            try{
                while(shouldSub){
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for(int j=1;j<=10;j++){
                    System.out.println("***********Main thread sequence of "+ j+", loop of "+i);
                }
                shouldSub=true;
                condition.signalAll();
            }finally {
                lock.unlock();
            }
        }

        public void sub(int i){
            lock.lock();
            try{
                while(!shouldSub){
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for(int j=1;j<=10;j++){
                    System.out.println("Sub thread sequence of "+ j+", loop of "+i);
                }
                shouldSub=false;
                condition.signalAll();
            }finally {
                lock.unlock();
            }
        }
    }


}
