package Volume_I.Chapter3;

import java.util.Scanner;

/**
 * Created by Star Yang on 2017/1/8.
 */
public class D_BreakAllLoop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        read_data:
        {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print("Enter a number: ");
                    n = in.nextInt();
                    if (n < 0) {
                        break read_data;
                    }
                    System.out.println("Inner loop : " + (j + 1));
                }
                System.out.println("Outer loop: " + (i + 1));
            }
        }
        if (n < 0) {
            System.out.println("Break out of all loop");
        } else {
            System.out.println("Work through all loop");
        }
    }
}
