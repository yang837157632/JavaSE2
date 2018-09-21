package Volume_I.Chapter12;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

/**
 * Created by Star Yang on 2017/2/17.
 */
//http://blog.csdn.net/navyhu/article/details/40537175#
public class D_Test {
    @Test
    public void test1() {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        arrayList1.add("abc");
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        arrayList2.add(123);
        System.out.println(arrayList1.getClass() == arrayList2.getClass());
    }

    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
        arrayList3.add(1);//这样调用add方法只能存储整形，因为泛型类型的实例为Integer
        arrayList3.getClass().getMethod("add", Object.class).invoke(arrayList3, "asd");
        for (int i = 0; i < arrayList3.size(); i++) {
            System.out.println(arrayList3.get(i));
        }
    }

    @Test
    public void test3(){
        try {
            Class<?> cl = Class.forName("java.util.Map");
//            Class<?> cl = Class.forName("java.util.Collections");
            TypeVariable<? extends Class<?>>[] typeParameters = cl.getTypeParameters();
            if(typeParameters.length==0){
                System.out.println("Haha Haha Haha Haha");
                return;
            }
            for(int i=0;i<typeParameters.length;i++){
                System.out.println(typeParameters[i].getName());
                System.out.println(typeParameters[i].getBounds().length);
                System.out.println(typeParameters[i].getBounds()[0]);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4(){
        try {
            Class<?> cl = Class.forName("java.util.ArrayList");
//            Class<?> cl = Class.forName("java.util.List");
//            Class<?> cl = Class.forName("java.util.Collections");
            Type genericSuperclass = cl.getGenericSuperclass();
            System.out.println(genericSuperclass + "*****");

            Type[] genericInterfaces = cl.getGenericInterfaces();
            if(genericInterfaces.length==0){
                System.out.println("Yeah Yeah Yeah Yeah");
                return;
            }
            for(int i=0;i<genericInterfaces.length;i++){
                System.out.println(genericInterfaces[i]);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5(){
        try {
//            Class<?> cl = Class.forName("java.util.ArrayList");
//            Class<?> cl = Class.forName("java.util.List");
            Class<?> cl = Class.forName("java.util.Collections");
            Method[] methods = cl.getDeclaredMethods();
            if(methods.length==0){
                System.out.println("Okok Okok Okok Okok");
                return;
            }
            Method method = methods[0];
            System.out.println(method);

            TypeVariable<Method>[] typeParameters = method.getTypeParameters();
            if(typeParameters.length==0){
                System.out.println("getTypeParameters length 000");
                return;
            }
            for(int i=0;i<typeParameters.length;i++){
                System.out.println(typeParameters[i]);
            }

            Type genericReturnType = method.getGenericReturnType();
            if(genericReturnType==null){
                System.out.println("getGenericReturnType length 000");
                return;
            }
            System.out.println("genericReturnType   " +genericReturnType);

            Type[] genericParameterTypes = method.getGenericParameterTypes();
            if(genericParameterTypes.length==0){
                System.out.println("getGenericParametersTypes length 000");
                return;
            }
            for(int j=0;j<genericParameterTypes.length;j++){
                System.out.println(genericParameterTypes[j]);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
