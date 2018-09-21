package Volume_I.Chapter3;

/**
 * Created by Star Yang on 2017/1/8.
 */
public class B_OutputFormat {
    public static void main(String[] args){
        double x = 10000000/3.0;
        System.out.println(x);
        System.out.printf("%12.2f*****\n",x);
        System.out.printf("%,.2f*****\n",x);
    }
}
