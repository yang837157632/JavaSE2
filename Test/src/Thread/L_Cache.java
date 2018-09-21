package Thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Star Yang on 2016/11/24.
 */
public class L_Cache {
    public static void main(String[] args){
        System.out.println(new L_Cache().getData(""+0));
    }

    private Map<String,Objects> map = new HashMap<String, Objects>();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public Object getData(String key) {
        readWriteLock.readLock().lock();
        Object value = null;
        try {
            value=map.get(key);
            if(value==null){
                readWriteLock.readLock().unlock();
                readWriteLock.writeLock().lock();
                try{
                    if(value==null){
                        value=new Random().nextInt();
                    }
                }finally {
                    readWriteLock.writeLock().unlock();
                }
                readWriteLock.readLock().lock();
            }
        } finally {
            readWriteLock.readLock().unlock();
        }
        return value;
    }
}
