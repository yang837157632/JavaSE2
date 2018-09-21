package Thread;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Semaphore;

/**
 * Created by Star Yang on 2016/11/25.
 */
public class X_Test extends Thread{

    private TestDo2 testDo2;
    private String key;
    private String value;

    public static void main(String[] args){
        X_Test a= new X_Test("1","","1");
        X_Test b= new X_Test("1","","2");
        X_Test c= new X_Test("3","","3");
        X_Test d= new X_Test("4","","4");
        X_Test e= new X_Test("3","","5");

        System.out.println("begin.....");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();

    }

    public void run(){
        testDo2.doSome(key,value);
    }

    public X_Test(String key, String key2 ,String value) {
        this.testDo2 = TestDo2.getInstance();
//        this.key = key;
        this.key = key+key2;
        this.value = value;
    }
}



class TestDo2{
    private TestDo2() {  }
    public  static TestDo2 testDo2 = new TestDo2();
    public static TestDo2 getInstance(){
        return testDo2;
    }

    //   List list= new ArrayList();
//    private List set= new CopyOnWriteArrayList();
    private Set set = new CopyOnWriteArraySet();
    private Semaphore semaphore = new Semaphore(1);

    public void doSome(Object key,String value){

        Object o = key;
        try {
            semaphore.acquire();
            if(!set.contains(o)){
                set.add(o);
            }else{
                for(Iterator iterator = set.iterator();iterator.hasNext();){
                    Object next = iterator.next();
                    if(o.equals(next)){
                        o=next;
                        break;
                    }
                }
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (o){
            try {
                Thread.sleep(1000);
                System.out.println(key+"--"+value+"--"+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}