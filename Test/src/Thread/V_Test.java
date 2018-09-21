package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Star Yang on 2016/11/25.
 */
public class V_Test {
    public static void main(String[] args){
        final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(16);

        for(int i=0;i<4;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        try {
                            String log = queue.take();
                            parseLog(log);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        System.out.println("begin ...... " );
        for(int i=0;i<16;i++){
            try {
                String log = ""+(i+1);
                queue.put(log);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void parseLog(String log){
        System.out.println(log + " : " + System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
