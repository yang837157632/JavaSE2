package Volume_I.Chapter5;

import java.util.Scanner;

/**
 * Created by Star Yang on 2017/1/14.
 */
public class B_Ellipsis {
    public static void main(String... args){
        Scanner in = new Scanner(System.in);
        System.out.print("Please input the size: ");
        int size = in.nextInt();
        double[] d = new double[size];
        for(int i=0;i<size;i++){
            d[i]= Math.random()*100;
            System.out.println(d[i]);
        }
        System.out.println("\n"+max(d));
    }

    public static double max(double... values){
        double max = Double.MIN_VALUE;
        for(double d: values){
            if(d > max){
                max = d;
            }
        }
        return max;
    }
}
