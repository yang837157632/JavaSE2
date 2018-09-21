package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Star Yang on 2016/11/23.
 */
public class H_ThreadPool {

    public static void main(String[] args){

//        固定大小线程池
//        ExecutorService pool = Executors.newFixedThreadPool(3);

//        缓存线程池
       ExecutorService pool =  Executors.newCachedThreadPool();

//        单一线程池，线程死掉之后会重新开启一个线程池
//       ExecutorService pool =  Executors.newSingleThreadExecutor();

        for(int i=1;i<=10;i++){
            final int task = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<=10;j++){
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+" loop of "+j+", for task "+task);
                    }
                }
            });
        }

        System.out.println("ALL Task Are Committed");
        System.out.println(((ThreadPoolExecutor)pool).getLargestPoolSize());
        pool.shutdown();
//        pool.shutdownNow();

//        定时线程池
//        Executors.newSingleThreadScheduledExecutor().schedule(
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        System.err.println("bombing...");
//                    }
//                },3, TimeUnit.SECONDS
//        );

//        定时连续线程池
        Executors.newScheduledThreadPool(3).scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        System.err.println("bombing...");
                    }
                },3,2, TimeUnit.SECONDS
        );
    }
}
