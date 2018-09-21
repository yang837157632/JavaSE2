package Thread;

/**
 * Created by Star Yang on 2016/11/22.
 */
public class A_Thread {
    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                try {
                    while (true){
                        Thread.sleep(1000);
                        System.out.println("Thread***************"+Thread.currentThread().getName());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread1.start();


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        Thread.sleep(1000);
                        System.out.println("Runnable "+Thread.currentThread().getName());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true){
                        Thread.sleep(1000);
                        System.err.println("Runnable....."+Thread.currentThread().getName());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }){
            @Override
            public void run() {
                try {
                    while(true){
                        Thread.sleep(1000);
                        System.err.println("Thread....."+Thread.currentThread().getName());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }
}
