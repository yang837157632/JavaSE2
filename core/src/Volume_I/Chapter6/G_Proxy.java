package Volume_I.Chapter6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Star Yang on 2017/1/17.
 */
public class G_Proxy {
    public static void main(String[] args){
        Object[] objects = new Object[1000];
        for(int i=0;i<objects.length;i++){
            Integer value = i+1;
            InvocationHandler handler = new MyHandler(value);
            Object proxy = Proxy.newProxyInstance(null,new Class[]{Comparable.class},handler);
            objects[i] = proxy;
        }
        Integer key = new Random().nextInt(objects.length)+1;
        int result = Arrays.binarySearch(objects, key);
        if(result>=0){
            System.out.println(result + "\t" + objects[result]);
        }

    }
}

class MyHandler implements InvocationHandler{
    private Object target;

    public MyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print("Target :" + target);
        System.out.print("\t\tMethod :" + method.getName()+"\t\t");
        if(args!=null){
            for(Object object : args){
                System.out.print(object + "\t");
            }
        }
        System.out.println();
        return method.invoke(target,args);
    }
}
