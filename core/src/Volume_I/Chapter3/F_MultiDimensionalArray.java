package Volume_I.Chapter3;

import java.util.Arrays;

/**
 * Created by Star Yang on 2017/1/8.
 */
public class F_MultiDimensionalArray {
    public static void main(String[] args){
        int[][] array = new int[3][4];
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                array[i][j] = (int) (Math.random()*100);
            }
        }

        for(int[] row : array){
            for(int number : row){
                System.out.print(number+"\t");
            }
            System.out.println();
        }

        System.out.println("\n"+ Arrays.deepToString(array));
    }
}
