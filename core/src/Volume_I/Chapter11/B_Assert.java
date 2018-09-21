package Volume_I.Chapter11;

/**
 * Created by Star Yang on 2017/2/10.
 */
//E:\IDEA\Workspace\out\production\core>java -ea Volume_I.Chapter11.B_Assert
public class B_Assert {
    public static void main(String[] args){
        assert true;
        System.out.println("Assert True : Go");
        System.out.println("\n----------\n");
        assert false: "Assert failure, this syntax will show when throw an exception";
        System.out.println("Assert False : Go");
    }
}
