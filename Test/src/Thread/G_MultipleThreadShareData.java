package Thread;

/**
 * Created by Star Yang on 2016/11/23.
 */
public class G_MultipleThreadShareData {

    public static void main(String[] args) {

        final ShareData shareData = new ShareData();
        ShareData shareData2 = new ShareData();

        new Thread(new MyRunnableA(shareData2)).start();
        new Thread(new MyRunnableB(shareData2)).start();
        new Thread(new MyRunnableA(shareData2)).start();
        new Thread(new MyRunnableA(shareData2)).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                shareData.increment();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                shareData.decrement();
            }
        }).start();
    }
}

class MyRunnableA implements Runnable {

    private ShareData shareData;

    public MyRunnableA(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        shareData.increment();
    }
}

class MyRunnableB implements Runnable {

    private ShareData shareData;

    public MyRunnableB(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        shareData.decrement();
    }
}


class ShareData {
    private int data = 0;

    public synchronized void increment() {
        data++;
        System.out.println(Thread.currentThread().getName() + " Data has increased, data = " + data);
    }

    public synchronized void decrement() {
        data--;
        System.out.println(Thread.currentThread().getName() + " Data has decreased, data = " + data);
    }
}
