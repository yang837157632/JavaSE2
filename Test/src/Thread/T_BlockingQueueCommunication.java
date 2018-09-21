package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Star Yang on 2016/11/24.
 */
public class T_BlockingQueueCommunication {

    public static void main(String[] args){
        final BlockBusiness business = new BlockBusiness();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=10;i++){
                    business.sub(i);
                }
            }
        }).start();

        for(int i=1;i<=10;i++){
            business.main(i);
        }
    }

    public static class BlockBusiness{

        BlockingQueue queue1 = new ArrayBlockingQueue(1);
        BlockingQueue queue2 = new ArrayBlockingQueue(1);
        {
            try {
                queue1.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void main(int i){
            try {
                queue1.put(1);
                for(int j=1;j<=10;j++){
                    System.out.println("**************** Main thread sequence of "+j+" , loop of "+i);
                }
                queue2.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void sub(int i){
            try {
                queue2.put(1);
                for(int j=1;j<=10;j++){
                    System.out.println("Sub thread sequence of "+j+" , loop of "+i);
                }
                queue1.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
