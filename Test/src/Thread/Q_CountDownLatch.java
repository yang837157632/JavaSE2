package Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Star Yang on 2016/11/24.
 */
public class Q_CountDownLatch {

    public static void main(String[] args){
        ExecutorService threadPool = Executors.newCachedThreadPool();
        final CountDownLatch count1 = new CountDownLatch(1);
        final CountDownLatch count2 = new CountDownLatch(3);

        for(int i=0;i<3;i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("线程"+Thread.currentThread().getName()+ "正准备接受命令");
                        count1.await();
                        System.out.println("线程"+Thread.currentThread().getName()+"已接受命令");
                        Thread.sleep((long)(Math.random()*10000));
                        count2.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            threadPool.execute(runnable);
        }

        try{
            Thread.sleep((long)Math.random()*10000);
            System.out.println("线程"+Thread.currentThread().getName()+"即将发布命令");
            count1.countDown();
            System.out.println("线程"+Thread.currentThread().getName()+ "已发布命令，正在等待结果");
            count2.await();
            System.out.println("线程"+Thread.currentThread().getName()+"已收到所有相应结果");
        }catch(Exception e){
            e.printStackTrace();
        }

        threadPool.shutdown();
    }
}
