package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Star Yang on 2016/11/24.
 */
public class O_Semaphore {

//    线程信号灯
    public static void main(String[] args){
        ExecutorService threadPool = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        for(int i=1;i<=10;i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程"+Thread.currentThread().getName()+
                            "进入，当前已有"+(3-semaphore.availablePermits())+"个并发");
                    try {
                        Thread.sleep((long)(Math.random()*10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程"+Thread.currentThread().getName()+"即将离开");
                    semaphore.release();
                    System.out.println("线程"+Thread.currentThread().getName()+
                            "已离开，当前已有"+(3-semaphore.availablePermits())+"个并发");
                }
            };
            threadPool.execute(runnable);
        }
        threadPool.shutdown();
    }
}
