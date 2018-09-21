package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Star Yang on 2016/11/24.
 */
public class S_BlockingQueue {

    public static void main(String[] arga){
        final BlockingQueue queue = new ArrayBlockingQueue(3);

        for(int i=0;i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            Thread.sleep((long)(Math.random()*1000));
                            System.out.println("线程"+Thread.currentThread().getName()+ "准备放数据");
                            queue.put(Math.random()*10000);
                            System.out.println("线程"+Thread.currentThread().getName()+"已经放了数据，队列中目前有"+queue.size()+"个数据");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep((long)(Math.random()*100));
                        System.out.println("**********线程" + Thread.currentThread().getName() + "准备取数据");
                        queue.take();
                        System.out.println("**********线程"+Thread.currentThread().getName()+ "已经取了数据，队列中目前有"+queue.size()+"个数据");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
