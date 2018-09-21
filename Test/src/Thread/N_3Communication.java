package Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Star Yang on 2016/11/24.
 */
public class N_3Communication {

    public static void main(String[] args){

        final Business3 business = new Business3();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=50;i++){
                    business.middle(i);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=50;i++){
                    business.younger(i);
                }
            }
        }).start();

        for(int i=1;i<=50;i++){
            business.elder(i);
        }
    }



    public static class Business3{

        Lock lock = new ReentrantLock();
        Condition elder = lock.newCondition();
        Condition middle = lock.newCondition();
        Condition younger = lock.newCondition();
        private int choose = 1;

        public void elder( int i){
            lock.lock();
            try{
                while(choose!=1){
                    try {
                        elder.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for(int j=1;j<=10;j++){
                    System.out.println("**********Big Brother thread sequence of "+j+" , loop of "+i);
                }
                choose = 2;
                middle.signal();
            }finally {
                lock.unlock();
            }
        }


        public void middle( int i){
            lock.lock();
            try{
                while(choose!=2){
                    try {
                        middle.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for(int j=1;j<=10;j++){
                    System.out.println("..........Second Brother thread sequence of "+j+" , loop of "+i);
                }
                choose = 3;
                younger.signal();
            }finally {
                lock.unlock();
            }
        }


        public void younger( int i){
            lock.lock();
            try{
                while(choose!=3){
                    try {
                        younger.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for(int j=1;j<=10;j++){
                    System.out.println("Young Brother thread sequence of "+j+" , loop of "+i);
                }
                choose = 1;
                elder.signal();
            }finally {
                lock.unlock();
            }
        }
    }
}
