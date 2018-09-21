package Thread;

/**
 * Created by Star Yang on 2016/11/22.
 */
public class C_Synchronized {

    public static void main(String[] args) {
        final Output output = new Output();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    output.put2("123456");
//                    output.put3("123456");
                    output.s_put1("987654321");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    output.put1("abcdefg");
//                    output.put4("abcdefg");
                    output.s_put2("zyxwvu");
                }
            }
        }).start();
    }
}

class Output {
    public void put1(String name) {
        for (int i = 0; i < name.length(); i++) {
            System.out.print(name.charAt(i));
        }
        System.out.println();
    }

    public void put2(String name) {
        for (int i = 0; i < name.length(); i++) {
            System.out.print(name.charAt(i));
        }
        System.out.println();
    }

    public void put3(String name) {
        synchronized (this) {
            for (int i = 0; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }

    public synchronized void put4(String name) {
        for (int i = 0; i < name.length(); i++) {
            System.out.print(name.charAt(i));
        }
        System.out.println();
    }

    public void s_put1(String name) {
        synchronized (Output.class) {
            for (int i = 0; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }

    public static synchronized void s_put2(String name) {
        for (int i = 0; i < name.length(); i++) {
            System.out.print(name.charAt(i));
        }
        System.out.println();
    }

}
