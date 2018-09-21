package Volume_I.Chapter5;

import java.lang.reflect.Method;

/**
 * Created by Star Yang on 2017/1/15.
 */
public class F_MethodReflection {
    public static void main(String[] args){
        try {
            Method square = F_MethodReflection.class.getMethod("square", double.class);
            Method sqrt = Math.class.getMethod("sqrt", double.class);

            printTable(1,10,10,square);
            System.out.println();
            printTable(1,10,10,sqrt);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static double square(double d){
        return d*d;
    }

    public static void printTable(double from, double to, double n, Method method){
        System.out.println(method);
        double dx = (to-from)/(n-1);
        for(double x = from; x<= to;x+= dx){
            try{
                double y = (Double)method.invoke(null,x);
                System.out.printf("%10.4f | %10.4f\n", x, y);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
