package Strategy;

import java.util.Arrays;

/**
 * Created by Star Yang on 2016/11/29.
 */
public class TestTree {

    public static void main(String[] args){
        Tree[] trees = new Tree[6];

        for(int i=0;i<6;i++){
            trees[i] = new Tree((int)(Math.random()*10),Math.random()*100);
        }

        for(int i=0;i<6;i++){
            System.out.println(trees[i]);
        }

        Arrays.sort(trees);
        System.out.println();

        for(int i=0;i<6;i++){
            System.out.println(trees[i]);
        }

    }
}
