package Thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Star Yang on 2016/11/22.
 */
public class B_Timer {

    private static int i = 1;

    public static void main(String[] args) {

//        定时器
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("**********bombing");
//            }
//        },1000);


//        连续定时器
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("**********bombing");
//            }
//        },5000,1000);


//        子母定时器
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("**********bombing1");
//                new Timer().schedule(new TimerTask() {
//                    @Override
//                    public void run() {
//                        System.out.println("**********bombing2");
//                    }
//                },3000);
//            }
//        },2000);


//        递归定时器
//        class MyTimeTask extends TimerTask {
//            @Override
//            public void run() {
//                i = (i+1)%2;
//                System.out.println("**********bombing");
//                new Timer().schedule(new MyTimeTask(),2000*(i+1));
//            }
//        }
//        new Timer().schedule(new MyTimeTask(), 1000);


//        交替定时器
        new Timer().schedule(new B_Timer().new TimeTaskA(), 1000);

        while (true) {
            try {
                System.out.println(new Date().getSeconds());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    class MyTimeTaskB extends TimerTask {
        @Override
        public void run() {
            System.out.println("**********bombingB");
            new Timer().schedule(new TimeTaskA(),2000);
        }
    }


    class TimeTaskA extends TimerTask {
        @Override
        public void run() {
            System.out.println("**********bombingA");
            new Timer().schedule(new MyTimeTaskB(),2000);
        }
    }
}