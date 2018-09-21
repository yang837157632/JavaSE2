package Thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Star Yang on 2016/11/24.
 */
public class R_Exchange {

    public static void main(String[] args){
        ExecutorService threadPool = Executors.newCachedThreadPool();
        final Exchanger exchanger = new Exchanger();
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String data1 = "abcdedf";
                    System.out.println("**********交换前线程 "+Thread.currentThread().getName()+" 的数据: "+data1);
                    Thread.sleep((long)(Math.random()*10000));
                    String data2 = (String) exchanger.exchange(data1);
                    System.out.println("**********交换后线程 "+Thread.currentThread().getName()+" 的数据: "+data2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String data1 = "1234567";
                    System.out.println("----------交换前线程 "+Thread.currentThread().getName()+" 的数据: "+data1);
                    Thread.sleep((long)(Math.random()*1000));
                    String data2 = (String) exchanger.exchange(data1);
                    System.out.println("----------交换后线程 "+Thread.currentThread().getName()+" 的数据: "+data2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.shutdown();
    }
}
