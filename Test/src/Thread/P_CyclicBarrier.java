package Thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Star Yang on 2016/11/24.
 */
public class P_CyclicBarrier {

    //    线程障碍
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random() * 1000));
                        System.out.println("线程" + Thread.currentThread().getName() + "到达集合点1，当前已有" +
                                (cyclicBarrier.getNumberWaiting() + 1) + "个线程到达集合点1，" +
                                (cyclicBarrier.getNumberWaiting() == 2 ? "都到齐了，继续前进" : "正在等待"));
                        cyclicBarrier.await();

                        Thread.sleep((long) (Math.random() * 1000));
                        System.out.println("线程" + Thread.currentThread().getName() + "到达集合点2，当前已有" +
                                (cyclicBarrier.getNumberWaiting() + 1) + "个线程到达集合点2，" +
                                (cyclicBarrier.getNumberWaiting() == 2 ? "都到齐了，继续前进" : "正在等待"));
                        cyclicBarrier.await();

                        Thread.sleep((long) (Math.random() * 1000));
                        System.out.println("线程" + Thread.currentThread().getName() + "到达集合点3，当前已有" +
                                (cyclicBarrier.getNumberWaiting() + 1) + "个线程到达集合点3，" +
                                (cyclicBarrier.getNumberWaiting() == 2 ? "都到齐了，继续前进" : "正在等待"));
                        cyclicBarrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            threadPool.execute(runnable);
        }
        threadPool.shutdown();
    }
}
