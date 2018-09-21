package Thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Star Yang on 2016/11/25.
 */
public class W_Test {
    public static void main(String[] args){
//        信号灯，保证队列一个一个取
        final Semaphore semaphore = new Semaphore(1);
//        同步队列，取放同步，同exchange
        final BlockingQueue<String> queue = new SynchronousQueue<String>();

        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        String take = queue.take();
                        String s = TestDo.doSome(take);
                        System.out.println(Thread.currentThread().getName()+" : "+ s);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        System.out.println("begin......");
        for(int i=0;i<10;i++){
            String input = i+"";
            try {
                queue.put(input);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class TestDo{
    public static String doSome(String input){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String output = input + " : " + System.currentTimeMillis();
        return output;
    }
}
