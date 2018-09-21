package Volume_I.Chapter4;

import java.text.NumberFormat;

/**
 * Created by Star Yang on 2017/1/11.
 */
public class B_NumberFormat {
    public static void main(String[] args){
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        double x= 0.1;
        System.out.println(currencyFormat.format(x));
        System.out.println(percentFormat.format(x));
    }
}
